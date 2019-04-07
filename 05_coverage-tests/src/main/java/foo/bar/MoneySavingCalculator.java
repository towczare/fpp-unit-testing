package foo.bar;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;

public class MoneySavingCalculator {

    public BigDecimal calculateSavings(
            SavingFrequency frequency,
            BigDecimal singleAmmount,
            Period duration
    ) {
        //1. Period -> ilość dni
        //2. ilość dni / frequency.getDays() -> ilośc transakcji
        //3. ilośc transakcji * singleAmmount

        // *
        return singleAmmount.multiply(BigDecimal.valueOf(duration.getYears()));
    }
}
