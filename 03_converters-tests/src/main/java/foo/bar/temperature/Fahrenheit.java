package foo.bar.temperature;

import java.math.BigDecimal;
import java.util.Objects;

public class Fahrenheit implements Temperature {

    private final BigDecimal value;

    public Fahrenheit(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fahrenheit)) return false;
        Fahrenheit that = (Fahrenheit) o;
        return value.doubleValue() == that.value.doubleValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public BigDecimal getValue() {
        return value;
    }
}
