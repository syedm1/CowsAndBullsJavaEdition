package src.core;

import src.interfaces.AIGuesserInterface;
import src.interfaces.ScoreCalculatorInterface;
import src.models.AIGuessDetails;

public class AIBruteForceGuesser2 implements AIGuesserInterface {
    private int MAX_GUESS_LIMIT = 999999998;
    SecretGenerator guessGenerator;

    public AIBruteForceGuesser2() {
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

        return new AIGuessDetails(current_guess, secret, guess);
    }
}
