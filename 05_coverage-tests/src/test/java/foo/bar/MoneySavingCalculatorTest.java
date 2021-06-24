package foo.bar;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneySavingCalculatorTest {

    MoneySavingCalculator calc = new MoneySavingCalculator();

    @Test
    @DisplayName("During period of 1 year, when saving is 1000 once a YEAR, total savings should be 1000")
    void saveEachYearDuringYear1000pln() {
        Assertions.assertEquals(
                BigDecimal.valueOf(1000),
                calc.calculateSavings(SavingFrequency.ONCE_A_YEAR,
                        BigDecimal.valueOf(1000), Period.ofYears(1))
        );
    }

    private static Stream<Arguments> savings() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(10), SavingFrequency.EACH_WEEK, Period.ofYears(1), BigDecimal.valueOf(520))
        );
    }

    @ParameterizedTest(name = "When saving single amount {0} with following frequency {1} during given period {2} should save total {3}")
    @MethodSource("savings")
    void calculateSavings(BigDecimal singleAmount, SavingFrequency frequency, Period period, BigDecimal expectedSavings) {
        Assertions.assertEquals(expectedSavings, calc.calculateSavings(frequency, singleAmount, period));
    }

}
