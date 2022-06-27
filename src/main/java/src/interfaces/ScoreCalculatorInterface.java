package src.interfaces;

import src.models.ScoreDetails;

public interface ScoreCalculatorInterface {
    public ScoreDetails getScoreDetails(String input, String secret);
}
