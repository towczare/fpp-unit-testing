package foo.bar.bowling;

public class BowlingGame {
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        this.rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if(rolls[frameIndex] == 10) {
                score = score
                        + 10
                        + rolls[frameIndex + 1]
                        + rolls[frameIndex + 2];
                frameIndex++;
            }else if (isSpare(frame)) {
                    score += 10 + rolls[frameIndex + 2];
                    frameIndex += 2;
                } else {
                    score += rolls[frameIndex] + rolls[frameIndex + 1];
                    frameIndex += 2;
                }
            }
        return score;
    }

    private boolean isSpare(int frame) {
        return rolls[frame] + rolls[frame + 1] == 10;
    }
}
