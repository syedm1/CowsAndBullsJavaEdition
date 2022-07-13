package src.enums;


public enum AIGuessStrategies {
    Strategy1("brute1"),
    Strategy2("brute2");

    private String strategy;

    AIGuessStrategies(String strategy) {
        this.strategy = strategy;
    }

    public String getValue() {
        return strategy;
    }
}