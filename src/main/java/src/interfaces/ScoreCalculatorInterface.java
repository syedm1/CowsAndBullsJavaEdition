package src.interfaces;

public interface ScoreCalculatorInterface {
    public void initialize(String input, String secret);
    public int getBullsCount();
    public int getCowsCount();
    public String getBullsAndCowsAnalysis();
    public String getFinalDisplay();
}
