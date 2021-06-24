package foo.bar;

import java.math.BigDecimal;
import java.time.Period;

public class MoneySavingCalculator {

    private BigDecimal AVG_DAYS_IN_YEAR = BigDecimal.valueOf(365.25);
    private BigDecimal AVG_DAYS_IN_MONTH = BigDecimal.valueOf(30.44);

    public BigDecimal calculateSavings(
            SavingFrequency frequency,
            BigDecimal singleAmmount,
            Period duration
    ) {

        BigDecimal days = periodToDays(duration);

        BigDecimal howMany = BigDecimal.ZERO;

        switch (frequency) {
            case EACH_DAY:
                howMany = days;
                break;
            case EACH_WEEK:
                howMany = BigDecimal.valueOf(days.intValue() / 7);
                break;
            case EACH_MONTH:
                break;
            case EACH_SECOND_DAY:
                break;
            case TWICE_A_WEEK:
                break;
            case ONCE_A_YEAR:
                break;
        }


        return singleAmmount.multiply(howMany);
    }

    private BigDecimal periodToDays(Period duration) {

        BigDecimal daysInYears = BigDecimal.valueOf(duration.getYears()).multiply(AVG_DAYS_IN_YEAR);
        BigDecimal daysInMonths = BigDecimal.valueOf(duration.getMonths()).multiply(AVG_DAYS_IN_MONTH);
        BigDecimal days = BigDecimal.valueOf(duration.getDays());

        return daysInYears.add(daysInMonths).add(days);
    }
}
