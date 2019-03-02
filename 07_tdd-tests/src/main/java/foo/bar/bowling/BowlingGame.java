package foo.bar.bowling;

public class BowlingGame {

    private int score = 0;

    public void roll(int pins) {
        this.score = this.score + pins;
    }

    public int score() {
        return score;
    }
}
