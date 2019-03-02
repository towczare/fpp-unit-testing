package foo.bar.bowling;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class BowlingGameTest {

    private BowlingGame game;

    @BeforeEach
    @Description("Starting new game for test purpose")
    void setup() {
        game = new BowlingGame();
    }

    @Test
    @DisplayName("When player roll 0 pins 20 times in a row, his score should be 0 points")
    void testAllZeroGame() {
        rollMany(20, 0);

        Assertions.assertEquals(0, game.score());
    }

    @Test
    @DisplayName("When player roll 1 pin 20 times in a row, his score should be 20 points")
    void testAllOnesGame() {
        rollMany(20, 1);

        Assertions.assertEquals(20, game.score());
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }
}
