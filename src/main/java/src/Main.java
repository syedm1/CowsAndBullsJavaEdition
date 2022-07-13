package src;

import org.jetbrains.annotations.NotNull;
import src.core.*;
import src.enums.AIGuessStrategies;
import src.interfaces.*;

import java.util.ArrayList;
import java.util.Objects;

import static src.Utils.getRandomArrayItem;

public class Main {

    public static void main(String args[]) {


        System.out.println("Welcome");

        InputInterface inputInterface = new UserInput();
        ScoreCalculatorInterface scoreCalculatorInterface = new ScoreCalculator();
        SecretGeneratorInterface secretGeneratorInterface = new SecretGenerator();
        InputValidationInterface inputValidationInterface = new InputValidator();
        OutputInterface outputInterface = new OutputPrinter();


        Emulator emulator = Emulator.getInstance();

        emulator.setInputValidator(inputValidationInterface);
        emulator.setInput(inputInterface);
        emulator.setScoreCalculator(scoreCalculatorInterface);
        emulator.setSecretGenerator(secretGeneratorInterface);
        emulator.setOutputInterface(outputInterface);
        emulator.setContext(initializeContext());
        emulator.runGame();
    }

    public static @NotNull Context initializeContext() {
        // strategy pattern
        // https://refactoring.guru/design-patterns/strategy
        Context context = new Context();

        ArrayList<String> types = new ArrayList<>();
        types.add(AIGuessStrategies.Strategy1.getValue());
        types.add(AIGuessStrategies.Strategy2.getValue());

        String currentAIGuessStrategy = getRandomArrayItem(types);

        if (Objects.equals(currentAIGuessStrategy, AIGuessStrategies.Strategy1.getValue())) {
            context.setAIGuesserInterfaceStrategy(new AIBruteForceGuesser());
        } else {
            context.setAIGuesserInterfaceStrategy(new AIBruteForceGuesser2());
        }

        return context;
    }
}
