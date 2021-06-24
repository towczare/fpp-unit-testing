package foo.bar.smog;

public class PmAlarmService {

    public PmAlarmService() { }

    public AlarmLevel getAlarmMessage(int measurement, Country country) {
        return country.getAlarmLevel(measurement);
    }

}
