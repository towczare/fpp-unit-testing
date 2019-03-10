package foo.bar;

import java.math.BigDecimal;
import java.time.Period;

public class PeriodUtils {

    public static BigDecimal getDays(Period period) {
        return (
                    BigDecimal.valueOf(period.getYears())
                        .multiply(
                    BigDecimal.valueOf(365.24))
                ).add(
                    (BigDecimal.valueOf(period.getMonths())
                        .multiply(
                     BigDecimal.valueOf(30.43)))
                ).add(BigDecimal.valueOf(period.getDays()));
    }



}
