package foo.bar.temperature;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Celcius implements Temperature{

    public static final BigDecimal CELCIS_TO_FEHRENHEIT_PLUS = BigDecimal.valueOf(32).setScale(SCALE, ROUNDING_MODE);
    public static final BigDecimal CELCIS_TO_FEHRENHEIT_MULTIPLY = BigDecimal.valueOf(9).setScale(SCALE, ROUNDING_MODE)
            .divide(BigDecimal.valueOf(5).setScale(SCALE, ROUNDING_MODE)).setScale(SCALE, ROUNDING_MODE);
    private final BigDecimal value;

    public Celcius(BigDecimal value) {
        this.value = value;
    }

    //C * 9/5 + 32

    Fahrenheit toFahrenheit() {
        return new Fahrenheit(value.multiply(CELCIS_TO_FEHRENHEIT_MULTIPLY).setScale(SCALE, ROUNDING_MODE)
                .add(CELCIS_TO_FEHRENHEIT_PLUS).setScale(SCALE, ROUNDING_MODE));
    }

    Kelvin toKelvin() {
        return null;
    }

    public BigDecimal getValue() {
        return value;
    }
}
