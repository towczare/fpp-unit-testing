package foo.bar.smog;

public enum Country {

    POLAND( 200, 300),
    FRANCE( -1, 80),
    FINLAND(50, -1),
    ITALY(50, 75);

    private int minInfoLevel;
    private int minAlarmLevel;

    Country(int minInfoLevel, int minAlarmLevel) {
        this.minInfoLevel = minInfoLevel;
        this.minAlarmLevel = minAlarmLevel;
    }

    public AlarmLevel getAlarmLevel(int measurement) {
        if (measurement >= minAlarmLevel && minAlarmLevel != -1) {
            return AlarmLevel.WARNING;
        }

        if (measurement >= minInfoLevel && minInfoLevel != -1) {
            return AlarmLevel.INFO;
        }

        return AlarmLevel.NONE;
    }
}
