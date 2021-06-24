package foo.bar.meteorology.weather.alarm;

import foo.bar.meteorology.weather.Weather;
import foo.bar.meteorology.weather.WeatherService;

public class WeatherAlarmNotifier {

    private WeatherService weatherService;

    public WeatherAlarmNotifier(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public WeatherAlarmLevel raiseLevelIfNeccessary() {
        Weather weather = weatherService.getWeather();

        WeatherAlarmLevel level = WeatherAlarmLevel.ALL_OK;
        int alarms = 0;
        if (weather.getTemprature() > 35) {
            alarms++;
            level = WeatherAlarmLevel.SECOND_LEVEL;
        }

        if (weather.getWindSpeed() > 100) {
            alarms++;
            level = WeatherAlarmLevel.SECOND_LEVEL;
        }

        if (weather.getRainfall() > 100) {
            alarms++;
            level = WeatherAlarmLevel.THIRD_LEVEL;
        }

        if (alarms > 1) {
            level = WeatherAlarmLevel.FIRST_LEVEL;
        }

        return level;
    }
}
