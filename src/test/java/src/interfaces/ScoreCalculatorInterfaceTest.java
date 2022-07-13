package src.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.core.ScoreCalculator;
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
        ScoreDetails scoreDetails = scoreCalculator.getScoreDetails(1235, "1234");
        assertEquals(3, scoreDetails.getBullsCount());
    }

    @Test
    @DisplayName("Given a right guess we must have a winner")
    void testWinnerPrediction() {
        ScoreDetails scoreDetails = scoreCalculator.getScoreDetails(12345, "12345");
        assertTrue(scoreDetails.getIsWinner());
    }

    @Test
    @DisplayName("Given a right guess in wrong order there should be 4 cows")
    void testCowPrediction() {
        ScoreDetails scoreDetails = scoreCalculator.getScoreDetails(1234, "4321");
        assertEquals(4, scoreDetails.getCowsCount());
    }
}