package src;

import src.interfaces.InputInterface;
import src.interfaces.InputValidationInterface;
import src.interfaces.ScoreCalculatorInterface;
import src.interfaces.SecretGeneratorInterface;

public class Main {
    public static void main(String args[]) {
        System.out.println("Welcome");

        InputInterface inputInterface = new UserInput();
        ScoreCalculatorInterface scoreCalculatorInterface = new ScoreCalculator();
        SecretGeneratorInterface secretGeneratorInterface = new SecretGenerator();
        InputValidationInterface inputValidationInterface = new InputValidator();

        Emulator emulator = Emulator.getInstance();

        emulator.setInputValidator(inputValidationInterface);
        emulator.setInput(inputInterface);
        emulator.setScoreCalculator(scoreCalculatorInterface);
        emulator.setSecretGenerator(secretGeneratorInterface);

        emulator.runGame();
    }
}
