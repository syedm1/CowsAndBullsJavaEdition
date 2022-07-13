package src;

import src.core.*;
import src.interfaces.*;

public class Main {
    public static void main(String args[]) {
        System.out.println("Welcome");

        InputInterface inputInterface = new UserInput();
        ScoreCalculatorInterface scoreCalculatorInterface = new ScoreCalculator();
        SecretGeneratorInterface secretGeneratorInterface = new SecretGenerator();
        InputValidationInterface inputValidationInterface = new InputValidator();
        OutputInterface outputInterface = new OutputPrinter();
        AIGuessorInterface aiGuessorInterface = new AIBruteForceGuesser();

        Emulator emulator = Emulator.getInstance();

        emulator.setInputValidator(inputValidationInterface);
        emulator.setInput(inputInterface);
        emulator.setScoreCalculator(scoreCalculatorInterface);
        emulator.setSecretGenerator(secretGeneratorInterface);
        emulator.setOutputInterface(outputInterface);
        emulator.setAIInterface(aiGuessorInterface);

        emulator.runGame();
    }
}
