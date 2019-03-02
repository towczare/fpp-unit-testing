package foo.bar.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    @Test
    public void testAllZeroGame() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        Assertions.assertEquals(0, game.score());
    }

    @Test
    public void testAllOnesGame() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        Assertions.assertEquals(20, game.score());
    }
}
