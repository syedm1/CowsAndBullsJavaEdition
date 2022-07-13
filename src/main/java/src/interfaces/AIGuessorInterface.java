package src.interfaces;

import src.models.AIGuessDetails;

public interface AIGuessorInterface {
    public AIGuessDetails guess(String secret, ScoreCalculatorInterface scoreCalculatorInterface);
}
