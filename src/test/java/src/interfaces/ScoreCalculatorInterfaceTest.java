package src.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.Emulator;
import src.ScoreCalculator;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorInterfaceTest {

    ScoreCalculatorInterface scoreCalculator;

    @BeforeEach
    void setUp() {
        scoreCalculator = new ScoreCalculator();
    }

    @Test
    @DisplayName("Given a right guess there should be 4 bulls")
    void testBullPrediction() {
        scoreCalculator.initialize("1234", "1234");
       assertTrue(scoreCalculator.getBullsCount() == 4);
    }

    @Test
    @DisplayName("Given a right guess in wrong order there should be 4 cows")
    void testCowPrediction() {
        scoreCalculator.initialize("1234", "4321");
        assertTrue(scoreCalculator.getCowsCount() == 4);
    }

    @Test
    @DisplayName("Given scenario")
    void testOutputForGivenScenario() {
        scoreCalculator.initialize("9213", "1234");
        String expectedResult = "Response: 1 Bull(s), 2 Cow(s)(bulls = [2], cows = [1, 3])";
        assertEquals(expectedResult, scoreCalculator.getFinalDisplay() );
    }
}