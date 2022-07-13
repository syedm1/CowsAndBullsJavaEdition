package src.interfaces;

import src.models.AIGuessDetails;

public interface AIGuesserInterface {
    public AIGuessDetails guess(String secret, ScoreCalculatorInterface scoreCalculatorInterface);
}
