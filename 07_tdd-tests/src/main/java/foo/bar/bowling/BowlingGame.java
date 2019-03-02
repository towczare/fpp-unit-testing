package foo.bar.bowling;

public class BowlingGame {
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        this.rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        for (int i = 0; i < rolls.length; i++) {
            score += this.rolls[i];
        }
        return score;
    }
}
