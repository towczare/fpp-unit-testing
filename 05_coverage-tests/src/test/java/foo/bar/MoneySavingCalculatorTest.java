package foo.bar;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Period;

public class MoneySavingCalculatorTest {

    MoneySavingCalculator calc = new MoneySavingCalculator();

    @Test
    @Description("During period of 1 year, when saving is 1000 once a YEAR, total savings should be 1000")
    void saveEachYearDuringYear1000pln() {
        Assertions.assertEquals(
                BigDecimal.valueOf(1000),
                calc.calculateSavings(SavingFrequency.ONCE_A_YEAR,
                        BigDecimal.valueOf(1000), Period.ofYears(1))
        );
    }

    @Test
    @Description("During two years, once a week with average cost of 60 pln")
    void twoYearsOnceAWeek60plnSavings() {

        Period twoYears = Period.of(2, 3, 4);

        Assertions.assertEquals(
                BigDecimal.valueOf(2*52*60),
                calc.calculateSavings(SavingFrequency.ONCE_WEEK,
                        BigDecimal.valueOf(60), twoYears)
        );
    }

}
