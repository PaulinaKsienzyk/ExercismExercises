import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> rolls;
    private List<Integer> scores;
    private boolean isFirstRoll;
    private boolean isLastRoll;
    private boolean isBonusRoll;
    private boolean isEndOfGame;
    private int frame;
    private int frameScore;
    private int score;
    private int pinsLimit;

    public BowlingGame() {
        rolls = new ArrayList<>();
        scores = new ArrayList<>();
        score = 0;
        frame = 1;
        pinsLimit = 0;
        frameScore = 0;
        isFirstRoll = true;
        isLastRoll = false;
        isBonusRoll = false;
        isEndOfGame = false;
    }

    public int score() {
        if (!isEndOfGame) {
            throw new IllegalStateException("Score cannot be taken until the end of the game");
        }

        isFirstRoll = true;

        for (int i = 0; i < rolls.size(); i++) {
            frameScore += rolls.get(i);
            if (frameScore == 10) {
                if (isFirstRoll) {
                    frameScore += rolls.get(i + 1) + rolls.get(i + 2);
                    if (i == rolls.size() - 3) {
                        addFrameScore(frameScore);
                        break;
                    }
                } else {
                    frameScore += rolls.get(i + 1);
                    if (i == rolls.size() - 2) {
                        addFrameScore(frameScore);
                        break;
                    }
                }
                addFrameScore(frameScore);
            } else if (!isFirstRoll) {
                addFrameScore(frameScore);
            } else {
                isFirstRoll = false;
            }


        }

        for (int s : scores) {
            score += s;
        }

        return score;
    }

    public void roll(int pins) {
        if (pins < 0) throw new IllegalStateException("Negative roll is invalid");
        if (pins > 10) throw new IllegalStateException("Pin count exceeds pins on the lane");
        if (isEndOfGame) throw new IllegalStateException("Cannot roll after game is over");

        pinsLimit += pins;
        System.out.println(frame);

        if (pinsLimit > 10) throw new IllegalStateException("Pin count exceeds pins on the lane");

        if (frame == 10) {
            if (pinsLimit == 10) {
                if (isFirstRoll) {
                    isFirstRoll = false;
                    isBonusRoll = true;
                    pinsLimit = 0;
                } else if (!isLastRoll) {
                    isLastRoll = true;
                    isBonusRoll = true;
                    pinsLimit = 0;
                } else {
                    isEndOfGame = true;
                }
            } else {
                if (isFirstRoll) {
                    isFirstRoll = false;
                } else if (!isLastRoll && isBonusRoll) {
                    isLastRoll = true;
                } else {
                    isEndOfGame = true;
                }
            }
        } else {
            if (pinsLimit == 10 || !isFirstRoll) {
                endOfFrame();
            } else {
                isFirstRoll = false;
            }
        }

        rolls.add(pins);


    }

    private void addFrameScore(int score) {
        scores.add(score);
        frameScore = 0;
        isFirstRoll = true;
    }

    private void endOfFrame() {
        frame++;
        pinsLimit = 0;
        isFirstRoll = true;
    }

}
