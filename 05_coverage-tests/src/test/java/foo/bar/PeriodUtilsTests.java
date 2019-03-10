package foo.bar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.time.Period;

public class PeriodUtilsTests {



    @ParameterizedTest(name = "Period ({0} year, {1} months, {2} days) is equal to {3} days")
    @CsvSource({
            "2, 0, 0, 730.48",
            "1, 0, 1, 366.24",
    })
    public void twoYearsPeriodToDays(int y, int m, int d, double expectedDays) {
        Period period = Period.of(y, m, d);

        Assertions.assertEquals(BigDecimal.valueOf(expectedDays), PeriodUtils.getDays(period));
    }
}
