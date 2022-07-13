package src.core;

import src.interfaces.ScoreCalculatorInterface;
import src.models.ScoreDetails;

import java.util.ArrayList;
import java.util.List;


import static src.Utils.*;

public class ScoreCalculator implements ScoreCalculatorInterface {
    public ScoreDetails getScoreDetails(int currentInput, String currentSecret) throws RuntimeException {
        String input = String.valueOf(currentInput);
        ScoreDetails scoreDetails = new ScoreDetails();
        List<Character> _userGuess = stringToCharList(input);
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
