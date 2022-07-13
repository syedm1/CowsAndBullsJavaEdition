package src;

import src.interfaces.*;
import src.models.AIGuessDetails;
import src.models.ScoreDetails;

import java.util.Scanner;

public class Emulator {
    private static Emulator uniqueInstance;
    private ScoreCalculatorInterface _scoreCalculator;
    private SecretGeneratorInterface _secretGenerator;
    private InputInterface _input;
    private InputValidationInterface _inputValidator;
    private OutputInterface _output;
    private AIGuessorInterface _aiGuessInterface;
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

    public void setAIInterface(AIGuessorInterface aiGuessorInterface) {
        _aiGuessInterface = aiGuessorInterface;
    }

    public void setOutputInterface(OutputInterface output) {
        _output = output;
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

    private void matchGuess(String input, String secret) {
        ScoreDetails scoreDetails = _scoreCalculator.getScoreDetails(input, secret);
        _output.finalScoreDisplay(scoreDetails);
    }

    private String takeUserInput() {
        _output.requestUserForGuess();
        String input = scanner.nextLine();
        return input;
    }

    private boolean coreSelection(String secret, boolean continueGame) {
        _output.manualOrComputerGuess();
        int select = getUserIntInput();
        String userInput = "";

        if (select == 2) {
            AIGuessDetails aiGuessDetails = _aiGuessInterface.guess(secret, _scoreCalculator);
            _output.showAIGuessDetails(aiGuessDetails);
        } else {
            userInput = takeUserInput();
            guessStep(secret, userInput);
        }


        _output.requestUserToChooseGameOptions();
        select = getUserIntInput();

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

    private void guessStep(String secret, String userInput) {
        if (_inputValidator.isValidInput(userInput)) {
            matchGuess(userInput, secret);
        } else {
            _output.warnInvalidInput();
            coreSelection(secret, false);
        }
    }

    private int getUserIntInput() {
        int select;
        try {
            select = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            select = 0;
        }
        return select;
    }


}
