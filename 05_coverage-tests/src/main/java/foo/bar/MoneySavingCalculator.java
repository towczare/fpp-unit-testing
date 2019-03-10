package foo.bar;

import java.math.BigDecimal;
import java.time.Period;

public class MoneySavingCalculator {

    public static final int WEEK_DAYS = 7;

    public BigDecimal calculateSavings(
            SavingFrequency frequency,
            BigDecimal singleAmmount,
            Period duration
    ) {
        switch (frequency) {
            case ONCE_DAY:
                break;
            case ONCE_WEEK:
                //int weeks = duration.get(ChronoUnit.DAYS) / WEEK_DAYS;
                //return singleAmmount.multiply(BigDecimal.valueOf(weeks));
            case ONCE_MONTH:
                break;
            case ONCE_TWO_DAYS:
                break;
            case TWICE_A_WEEK:
                break;
            case ONCE_A_YEAR:
                break;
        }


        return singleAmmount;
    }
}
