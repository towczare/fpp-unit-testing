package foo.bar.meteorology.weather.alarm;

import foo.bar.meteorology.weather.Weather;
import foo.bar.meteorology.weather.WeatherService;
import foo.bar.meteorology.weather.external.RainfallProvider;
import foo.bar.meteorology.weather.external.TemperatureProvider;
import foo.bar.meteorology.weather.external.WindSpeedProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

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
    @Test
    public void testWeatherAlarmNotifier() {
        WeatherAlarmLevel weatherAlarmLevel = alarmNotifier.raiseLevelIfNeccessary();

        Assertions.assertEquals(WeatherAlarmLevel.ALL_OK, weatherAlarmLevel);
    }


    WeatherService weatherMock = Mockito.mock(WeatherService.class);

    private WeatherAlarmNotifier alarmNotifierWithMock
            = new WeatherAlarmNotifier(weatherMock);

    @ParameterizedTest(name = "When weatherService return " +
            "Weather (temp = {0} C, wind = {1} km/h, rain = {2} mm/day) " +
            "expected alarm status should be equal {3}")
    @CsvSource({
            "25, 10, 5, ALL_OK",
            "25, 100, 5, SECOND_LEVEL"
    })
    public void testWeatherAlarmNotifierTest(int temp, int wind, int rain, WeatherAlarmLevel expectedAlarm) {
        Mockito.when(weatherMock.getWeather())
                .thenReturn(new Weather(temp, wind, rain));

        WeatherAlarmLevel weatherAlarmLevel = alarmNotifierWithMock.raiseLevelIfNeccessary();

        Assertions.assertEquals(expectedAlarm, weatherAlarmLevel);
    }

}
