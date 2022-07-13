package src.core;

import src.interfaces.ScoreCalculatorInterface;
import src.models.ScoreDetails;

import java.util.ArrayList;
import java.util.List;


import static src.Utils.*;

public class ScoreCalculator implements ScoreCalculatorInterface {
    public ScoreDetails getScoreDetails(String currentInput, String currentSecret) throws RuntimeException {
        if (stringIsNullOrEmpty(currentInput) || stringIsNullOrEmpty(currentSecret)) {
            throw new RuntimeException("Corrupted input or data. Please try again later");
        }
        // @todo convert to int type before reaches interface
        if (!isInteger(currentInput)) {
            throw new RuntimeException("Invalid input only numbers are accepted. Please try again later");
        }

        ScoreDetails scoreDetails = new ScoreDetails();
        List<Character> _userGuess = stringToCharList(currentInput.toLowerCase());
        List<Character> _secret = stringToCharList(currentSecret);

        for (char num : _userGuess
        ) {
            if (_secret.contains(num)) {
                if (_userGuess.indexOf(num) == _secret.indexOf(num)) {
                    scoreDetails.incrementBulls();
                } else {
                    scoreDetails.incrementCows();
                }
            }
        }

        if (scoreDetails.getBullsCount() == currentSecret.length())
            scoreDetails.perfectScore();

        return scoreDetails;
    }

}
