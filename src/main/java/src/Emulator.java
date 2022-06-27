package src;

import src.interfaces.*;
import src.models.ScoreDetails;

import java.util.Scanner;

public class Emulator {
    private static Emulator uniqueInstance;
    private ScoreCalculatorInterface _scoreCalculator;
    private SecretGeneratorInterface _secretGenerator;
    private InputInterface _input;
    private InputValidationInterface _inputValidator;
    private OutputInterface _output;
    private Scanner scanner;
    private final boolean DEBUG = true;

    private Emulator() {
        scanner = new Scanner(System.in);
    }

    public static Emulator getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Emulator();
        }
        return uniqueInstance;
    }

    public void setScoreCalculator(ScoreCalculatorInterface scoreCalculator) {
        _scoreCalculator = scoreCalculator;
    }

    public void setSecretGenerator(SecretGeneratorInterface secretGenerator) {
        _secretGenerator = secretGenerator;
    }

    public void setInput(InputInterface input) {
        _input = input;
    }

    public void setInputValidator(InputValidationInterface validator) {
        _inputValidator = validator;
    }

    public void setOutputInterface(OutputInterface output) {
        _output = output;
    }

    private void matchGuess(String input, String secret) {
        ScoreDetails scoreDetails = _scoreCalculator.getScoreDetails(input, secret);
        _output.finalScoreDisplay(scoreDetails);
    }

    private String takeUserInput() {
        _output.requestUserForGuess();
        String input = scanner.nextLine();
        return input;
    }

    public void guessStep(String secret) {
        String userInput;
        userInput = takeUserInput();

        if (_inputValidator.isValidInput(userInput)) {
            matchGuess(userInput, secret);
        } else {
            _output.warnInvalidInput();
            guessStep(secret);
        }
    }

    public void runGame() {
        boolean continueGame = true;
        String secret = _secretGenerator.generateSecret();
        while (continueGame) {
            if (DEBUG) {
                _output.showSecret(secret);
            }
            continueGame = coreSelection(secret, continueGame);
        }
    }

    public boolean coreSelection(String secret, boolean continueGame) {
        guessStep(secret);
        _output.requestUserToChooseGameOptions();
        int select = getUserIntInput();

        switch (select) {
            case 0:
                continueGame = false;
            case 2:
                _output.giveUserHint(secret);
            default:
                continueGame = true;
        }

        return continueGame;
    }

    public int getUserIntInput() {
        int select;
        try {
            select = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            select = 0;
        }
        return select;
    }
}
