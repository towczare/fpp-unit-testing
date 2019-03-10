package foo.bar.meteorology.weather;

import foo.bar.meteorology.weather.external.RainfallProvider;
import foo.bar.meteorology.weather.external.TemperatureProvider;
import foo.bar.meteorology.weather.external.WindSpeedProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.logging.Logger;

class WeatherServiceTest {

    private WeatherService weatherService =
        new WeatherService(
            new TemperatureProvider(),
            new RainfallProvider(),
            new WindSpeedProvider()
        );

    @Test
    void testWeatherService() {
        Weather weather = weatherService.getWeather();
        Logger.getLogger("JUnit 5").info("Current weather : " + weather.toString());

        Assertions.assertNotNull(weather);
    }

    TemperatureProvider tempMock = Mockito.mock(TemperatureProvider.class);
    RainfallProvider rainMock = Mockito.mock(RainfallProvider.class);
    WindSpeedProvider windMock = Mockito.mock(WindSpeedProvider.class);

    private WeatherService weatherServiceMocked =
            new WeatherService(tempMock, rainMock, windMock);

    @Test
    void testWeatherServiceMock() {
        Mockito.when(tempMock.getTemperature()).thenReturn(30);
        Mockito.when(rainMock.getRainfallLevel()).thenReturn(10);
        Mockito.when(windMock.getWindSpeed()).thenReturn(100);

        Weather weather = weatherServiceMocked.getWeather();
        Logger.getLogger("JUnit 5").info("Current weather : " + weather.toString());

        Assertions.assertNotNull(weather);
    }
}
