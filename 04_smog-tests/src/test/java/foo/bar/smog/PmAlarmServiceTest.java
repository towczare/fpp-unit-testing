package foo.bar.smog;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PmAlarmServiceTest {

    @Test
    void shouldReturnNoneForMeasurement_10() {
        PmAlarmService service = new PmAlarmService();
        assertEquals(AlarmLevel.NONE, service.getAlarmMessage(10, Country.POLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_201() {
        PmAlarmService service = new PmAlarmService();
        assertEquals(AlarmLevel.INFO, service.getAlarmMessage(201, Country.POLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_350() {
        PmAlarmService service = new PmAlarmService();
        assertEquals(AlarmLevel.WARNING, service.getAlarmMessage(301, Country.POLAND));
    }

    @ParameterizedTest(name = "For measurement od PM10 = {0} in country = {1} given alarm = {3} should be returned")
    @CsvSource({
            "301, POLAND, WARNING",
            "49, FINLAND, NONE",
            "55, FINLAND, INFO"

    })
    void parametrizedTestOfEnums(int measurement, Country country, AlarmLevel expectedAlarm) {
        PmAlarmService service = new PmAlarmService();
        assertEquals(expectedAlarm, service.getAlarmMessage(measurement, country));
    }

}
