package src.interfaces;

import src.models.ScoreDetails;

public interface ScoreCalculatorInterface {
    public ScoreDetails getScoreDetails(int input, String secret);
}
