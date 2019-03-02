package foo.bar.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    @Test
    public void gameCreationTest() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        Assertions.assertEquals(0, game.score());
    }
}
