package foo.bar.temperature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

public class TemperatureTests {

    @ParameterizedTest(name = "{0} °C should be equal {1} °F")
    @CsvSource({
            "0.0, 32.00",
            "15.5, 59.90"
    })
    public void celciusToFahrenheit(double c, double f) {
        Celcius zero = new Celcius(BigDecimal.valueOf(c));

        Assertions.assertEquals(
                BigDecimal.valueOf(f),
                zero.toFahrenheit().getValue()
        );
    }

    @ParameterizedTest(name = "{0} °C should not be equal {1} °F")
    @CsvSource({
            "15.5, 59.10"
    })
    public void celciusToFahrenheitNotEqual(double c, double f) {
        Celcius zero = new Celcius(BigDecimal.valueOf(c));

        Assertions.assertNotEquals(
                BigDecimal.valueOf(f),
                zero.toFahrenheit().getValue()
        );
    }

}
