package src.core;

import src.interfaces.AIGuessorInterface;
import src.interfaces.ScoreCalculatorInterface;
import src.models.AIGuessDetails;

public class AIBruteForceGuesser implements AIGuessorInterface {
    private int MAX_GUESS_LIMIT = 999999999;
    SecretGenerator guessGenerator;

    public AIBruteForceGuesser() {
        guessGenerator = new SecretGenerator();
    }

    @Override
    public AIGuessDetails guess(String secret, ScoreCalculatorInterface scoreCalculatorInterface) {
        int current_guess = 0;
        boolean keepGuessing = true;
        String guess = "";

        while (current_guess < MAX_GUESS_LIMIT && keepGuessing) {
            current_guess += 1;
            guess = guessGenerator.generateSecret();
            keepGuessing = !secret.equals(guess);
        }

        return new AIGuessDetails(current_guess, !keepGuessing, secret, guess);
    }
}
