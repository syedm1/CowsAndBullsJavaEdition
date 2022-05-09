package src;

import src.interfaces.ScoreCalculatorInterface;

import java.util.ArrayList;
import java.util.List;


import static src.Utils.*;

public class ScoreCalculator implements ScoreCalculatorInterface {
    String currentInput;
    String currentSecret;
    int currentBullsCount;
    List<Integer> currentCowValues;
    int currentCowsCount;
    List<Integer> currentBullValues;

    public ScoreCalculator() {

    }

    @Override
    public void initialize(String input, String secret) {
        resetCalculator();
        currentCowValues = new ArrayList<>();
        currentBullValues = new ArrayList<>();
        currentInput = input;
        currentSecret = secret;
        calculateScores();
    }

    @Override
    public int getBullsCount() {
        return currentBullsCount;
    }

    @Override
    public int getCowsCount() {
        return currentCowsCount;
    }

    @Override
    public String getBullsAndCowsAnalysis() {
        return currentBullsCount +" Bull(s)" +", "+ currentCowsCount +" Cow(s)";
    }

    @Override
    public String getFinalDisplay() {
        return "Response: "+ getBullsAndCowsAnalysis()+ "(bulls = "+ currentBullValues +", cows = "+ currentCowValues +")";
    }


    private void resetCalculator() {
        currentInput = "";
        currentSecret = "";
        currentBullsCount = 0;
        currentCowValues = null;
        currentCowsCount = 0;
        currentBullValues = null;
    }

    private void calculateScores() throws RuntimeException {

        if (stringIsNullOrEmpty(currentInput) || stringIsNullOrEmpty(currentSecret)) {
            throw new RuntimeException("Corrupted input or data. Please try again later");
        }

        List<Character> _userGuess = stringToCharList(currentInput.toLowerCase());

        List<Character> _secret = stringToCharList(currentSecret);

        for (char num : _userGuess
        ) {
            if (_secret.contains(num)) {
                if (_userGuess.indexOf(num) == _secret.indexOf(num)) {
                    currentBullsCount += 1;
                    currentBullValues.add(charToInt(num));
                } else {
                    currentCowsCount += 1;
                    currentCowValues.add(charToInt(num));
                }
            }
        }

    }
}
