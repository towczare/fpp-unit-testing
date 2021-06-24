package foo.bar.meteorology.weather;

import foo.bar.meteorology.weather.external.RainfallProvider;
import foo.bar.meteorology.weather.external.TemperatureProvider;
import foo.bar.meteorology.weather.external.WindSpeedProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    TemperatureProvider mockTempProvider = mock(TemperatureProvider.class);
    RainfallProvider mockRainFallProvider = mock(RainfallProvider.class);
    WindSpeedProvider mockWindSpeedProvider = mock(WindSpeedProvider.class);

    private WeatherService weatherServiceWithMockedProviders = new WeatherService(
            mockTempProvider,
            mockRainFallProvider,
            mockWindSpeedProvider
    );

    @Test
    void testWeatherServiceWithMock() {
        when(mockTempProvider.getTemperature()).thenReturn(30);
        when(mockRainFallProvider.getRainfallLevel()).thenReturn(1);
        when(mockWindSpeedProvider.getWindSpeed()).thenReturn(10);

        Weather weather = weatherServiceWithMockedProviders.getWeather();
        Logger.getLogger("JUnit 5").info("Current weather : " + weather.toString());

        Assertions.assertNotNull(weather);
    }

}
