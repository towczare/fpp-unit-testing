package foo.bar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleTests {

    @ParameterizedTest(name = "Area of circle({0}) should be {1}")
    @CsvSource({
                 "0, 0",
                 "1, 3.14",
                 "2, 12.56"
    })
    void areaOfCircle(int a, double expectedArea) {
        Circle circle = new Circle(a);
        assertEquals(expectedArea, circle.area(), "Area of circle is different than expected");
    }
}
