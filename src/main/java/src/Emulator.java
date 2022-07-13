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
    private Context _context;
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

    public void setContext(Context context) {
        _context = context;
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

    private void matchGuess(int input, String secret) {
        ScoreDetails scoreDetails = _scoreCalculator.getScoreDetails(input, secret);
        _output.finalScoreDisplay(scoreDetails);
    }

    private String takeUserInput() {
        _output.requestUserForGuess();
        return scanner.nextLine();
    }

    private boolean coreSelection(String secret, boolean continueGame) {
        _output.manualOrComputerGuess();
        int select = getUserIntInput();
        String userInput = "";

        if (select == 2) {
            AIGuessDetails aiGuessDetails = _context.executeAIGuessStrategy(secret, _scoreCalculator);
            _output.showAIGuessDetails(aiGuessDetails);
        } else {
            userInput = takeUserInput();
            guessStep(secret, userInput);
        }


        _output.requestUserToChooseGameOptions();
        select = getUserIntInput();

        return manualSelectOptions(select, secret, continueGame);
    }

    private boolean manualSelectOptions(int select, String secret, boolean continueGame) {
        if (select == 1) {
            continueGame = true;
        } else if (select == 2) {
            continueGame = true;
            _output.giveUserHint(secret);
        } else {
            continueGame = false;
        }

        return continueGame;
    }

    private void guessStep(String secret, String userInput) {
        if (_inputValidator.isValidInput(userInput)) {
            matchGuess(_inputValidator.extractInteger(userInput), secret);
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
