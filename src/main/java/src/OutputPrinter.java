package src;

import src.interfaces.OutputInterface;
import src.models.ScoreDetails;

import static src.Utils.PrintToConsole;

public class OutputPrinter implements OutputInterface {

    @Override
    public void finalScoreDisplay(ScoreDetails scoreDetails) {
        //todo refactor this logic into score interface
        if (scoreDetails.getIsWinner()) {
            PrintToConsole("You guessed the secret. You are a master codebreaker \n");
        }
        PrintToConsole(scoreDetails.getBullsCount() + " Bull(s)" + ", " + scoreDetails.getCowsCount() + " Cow(s)");
    }

    public void warnInvalidInput() {
        PrintToConsole("Invalid input. Please try again with input of 4 Integers, Example: 1234");
    }

    @Override
    public void requestUserForGuess() {
        PrintToConsole("Take a guess");
    }

    @Override
    public void requestUserToChooseGameOptions() {
        PrintToConsole("Continue game? (0) No (1) Yes (2) Ask computer a hint");
    }

    @Override
    public void giveUserHint(String secret) {
        PrintToConsole("Computer hints :" + secret.substring(0, 2));
    }

    @Override
    public void showSecret(String secret) {
        PrintToConsole(secret);
    }
}

