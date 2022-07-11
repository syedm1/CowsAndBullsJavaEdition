package src.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.Emulator;
import src.ScoreCalculator;
import src.models.ScoreDetails;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorInterfaceTest {

    ScoreCalculatorInterface scoreCalculator;

    @BeforeEach
    void setUp() {
        scoreCalculator = new ScoreCalculator();
    }

    @Test
    @DisplayName("Given a guess with 3 correct values there should be 3 bulls")
    void testBullPrediction() {
        ScoreDetails scoreDetails = scoreCalculator.getScoreDetails("1235", "1234");
        assertTrue(scoreDetails.getBullsCount() == 3);
    }

      @Test
    @DisplayName("Given a right guess we must have a winner")
    void testWinnerPrediction() {
        ScoreDetails scoreDetails = scoreCalculator.getScoreDetails("12345", "12345");
        assertTrue(scoreDetails.getIsWinner());
    }

    @Test
    @DisplayName("Given a right guess in wrong order there should be 4 cows")
    void testCowPrediction() {
        ScoreDetails scoreDetails = scoreCalculator.getScoreDetails("1234", "4321");
        assertTrue(scoreDetails.getCowsCount() == 4);
    }

    @Test
    @DisplayName("Given a invalid guess there should be a RuntimeException")
    void testInvalidInput() {
        assertThrows(RuntimeException.class, () -> {
            scoreCalculator.getScoreDetails("abcd", "4321");
        });
    }

    @Test
    @DisplayName("Given a empty guess there should be a RuntimeException")
    void testEmptyInput() {
        assertThrows(RuntimeException.class, () -> {
            scoreCalculator.getScoreDetails("", "4321");
        });
    }
}