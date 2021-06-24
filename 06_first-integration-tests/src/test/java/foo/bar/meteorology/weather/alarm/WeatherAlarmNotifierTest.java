package foo.bar.meteorology.weather.alarm;

import foo.bar.meteorology.weather.Weather;
import foo.bar.meteorology.weather.WeatherService;
import foo.bar.meteorology.weather.external.RainfallProvider;
import foo.bar.meteorology.weather.external.TemperatureProvider;
import foo.bar.meteorology.weather.external.WindSpeedProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherAlarmNotifierTest {

    private WeatherAlarmNotifier alarmNotifier =
            new WeatherAlarmNotifier(
                new WeatherService(
                    new TemperatureProvider(),
                    new RainfallProvider(),
                    new WindSpeedProvider()
                )
            );

    //here comes your tests
    WeatherService weatherServiceMock = mock(WeatherService.class);

    private WeatherAlarmNotifier alarmNotifierWithMockerWeatherService = new WeatherAlarmNotifier(weatherServiceMock);

    @ParameterizedTest(name = "For given weather {0} should raise following alarm {1}")
    @MethodSource("provideWeatherAndExpectedAlarm")
    void shouldReturnInfoForMeasurement(Weather weather, WeatherAlarmLevel expectedAlarmLevel) {
        when(weatherServiceMock.getWeather()).thenReturn(weather);

        assertEquals(expectedAlarmLevel, alarmNotifierWithMockerWeatherService.raiseLevelIfNeccessary());
    }


    private static Stream<Arguments> provideWeatherAndExpectedAlarm() {
        return Stream.of(
                Arguments.of(new Weather(36,0,0), WeatherAlarmLevel.SECOND_LEVEL),
                Arguments.of(new Weather(10,110,0), WeatherAlarmLevel.SECOND_LEVEL),
                Arguments.of(new Weather(10,20,101), WeatherAlarmLevel.THIRD_LEVEL),
                Arguments.of(new Weather(36,120,101), WeatherAlarmLevel.FIRST_LEVEL),
                Arguments.of(new Weather(20,15,10), WeatherAlarmLevel.ALL_OK)
        );
    }

}
