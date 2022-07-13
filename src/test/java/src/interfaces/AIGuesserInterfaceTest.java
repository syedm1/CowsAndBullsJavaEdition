package src.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.core.AIBruteForceGuesser;
import src.core.ScoreCalculator;
import src.models.AIGuessDetails;

import static org.junit.jupiter.api.Assertions.*;

class AIGuesserInterfaceTest {

    ScoreCalculatorInterface scoreCalculator;
    AIGuesserInterface aiGuesser;

    @BeforeEach
    void setUp() {
        scoreCalculator = new ScoreCalculator();
        aiGuesser = new AIBruteForceGuesser();
    }

    @Test
    @DisplayName("Given a secret and score calculator the AI should make a guess")
    void testAIGuess() {
        AIGuessDetails details = aiGuesser.guess("1234", scoreCalculator);
        assertNotNull(details);
    }

    @Test
    @DisplayName("AI Guess is secret cracked value should be conditional equivalent of guess with current secret")
    void testAIGuessIsSecretCrackedCondition() {
        AIGuessDetails details = aiGuesser.guess("1234", scoreCalculator);
        assertEquals(details.isSecretCracked(), details.getGuess().equals("1234"));
    }
}