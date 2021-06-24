package foo.bar.smog;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static foo.bar.smog.Country.POLAND;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PmAlarmServiceTest {

    static long startExecution;

    @Test
    void shouldReturnNoneForMeasurement_10() {
        PmAlarmService service = new PmAlarmService();
        assertEquals(AlarmLevel.NONE, service.getAlarmMessage(10, POLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_201() {
        PmAlarmService service = new PmAlarmService();
        assertEquals(AlarmLevel.INFO, service.getAlarmMessage(201, POLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_350() {
        PmAlarmService service = new PmAlarmService();
        assertEquals(AlarmLevel.WARNING, service.getAlarmMessage(301, POLAND));
    }

    private static Stream<Arguments> provideMeasurementsCountryAndExpectedAlarm() {
        return Stream.of(
                Arguments.of(10, Country.POLAND, AlarmLevel.NONE),
                Arguments.of(201, Country.POLAND, AlarmLevel.INFO),
                Arguments.of(301, Country.POLAND, AlarmLevel.WARNING),
                Arguments.of(1, Country.FRANCE, AlarmLevel.NONE),
                Arguments.of(80, Country.FRANCE, AlarmLevel.WARNING),
                Arguments.of(79, Country.FRANCE, AlarmLevel.NONE),
                Arguments.of(1080, Country.FRANCE, AlarmLevel.WARNING),
                Arguments.of(49, Country.FINLAND, AlarmLevel.NONE),
                Arguments.of(50, Country.FINLAND, AlarmLevel.INFO),
                Arguments.of(540, Country.FINLAND, AlarmLevel.INFO)
        );
    }

    @ParameterizedTest(name = "For country {1} with measurement: {0} expected alarm should be {2}")
    @MethodSource("provideMeasurementsCountryAndExpectedAlarm")
    void shouldReturnInfoForMeasurement(int measurement, Country country, AlarmLevel expectedAlarm) {
        PmAlarmService service = new PmAlarmService();
        assertEquals(expectedAlarm, service.getAlarmMessage(measurement, country));
    }

    @BeforeAll
    static void classSetup() {
        startExecution = System.currentTimeMillis();
        Logger.getLogger("JUnit 5").info("Started at " + startExecution);
    }

    @AfterAll
    static void classTeardown() {
        Logger.getLogger("JUnit 5").info("Execution of tests took " + (System.currentTimeMillis() - startExecution) + " ms.");
    }



}
