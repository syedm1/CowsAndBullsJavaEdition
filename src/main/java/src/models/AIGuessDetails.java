package src.models;

public class AIGuessDetails {
    int numberOfAttempts;
    boolean secretCracked;
    String secret;
    String guess;

    public AIGuessDetails(int numberOfAttempts, String secret, String guess) {
        this.numberOfAttempts = numberOfAttempts;
        this.secret = secret;
        this.guess = guess;
        this.secretCracked = guess.equals(secret);
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public boolean isSecretCracked() {
        return secretCracked;
    }

    public String displayAIGuessDetails(){
       return secretCracked? "AI successfully guessed in: "+ numberOfAttempts +" attempts, for secret: "+ guess:
                "AI failed to guess in: "+ numberOfAttempts +" attempts, for secret: "+ secret;
    }

    public String getGuess() {
        return guess;
    }
}
