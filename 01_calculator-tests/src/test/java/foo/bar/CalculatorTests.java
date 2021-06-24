package foo.bar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTests {

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "1, 1, 0",
            "198, 18, 180",
            "-2, -18, 16",
            "100, 45, 150"
    })
    void substractTwoNumbers(int a, int b, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.substract(a, b),
                "Should substract values and return expected result");
    }

    @Test
    @DisplayName("198 - 18 = 180")
    void substractTwoBiggerNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(180, calculator.substract(198, 18), "198 - 18 should equal 180");
    }

    @Test
    @DisplayName("-2 - -18 = 16")
    void substractTwoNegativeNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(16, calculator.substract(-2, -18), "-2 - -18 should equal 16");
    }


}
