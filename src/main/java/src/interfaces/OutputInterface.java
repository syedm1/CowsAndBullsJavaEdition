package src.interfaces;


import src.models.AIGuessDetails;
import src.models.ScoreDetails;

public interface OutputInterface {
    public void finalScoreDisplay(ScoreDetails scoreDetails);
    public void warnInvalidInput();
    public void requestUserForGuess();
    public void manualOrComputerGuess();
    public void requestUserToChooseGameOptions();
    public void giveUserHint(String secret);
    public void showSecret(String secret);
    public void showAIGuessDetails(AIGuessDetails details);
}
