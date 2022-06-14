package src;

import src.interfaces.InputInterface;
import src.interfaces.InputValidationInterface;
import src.interfaces.ScoreCalculatorInterface;
import src.interfaces.SecretGeneratorInterface;

import java.util.Scanner;

import static src.Utils.isInteger;

public class Emulator {
    private static Emulator uniqueInstance;
    private ScoreCalculatorInterface _scoreCalculator;
    private SecretGeneratorInterface _secretGenerator;
    private InputInterface _input;
    private InputValidationInterface _inputValidator;
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

    private void matchGuess(String input,String secret){
        _scoreCalculator.initialize(input, secret);
        //@todo getScore, output Interface
//        _scoreCalculator.getScore(input,secret)
        PrintToConsole(_scoreCalculator.getFinalDisplay());
    }

    private String takeUserInput(){
        PrintToConsole("Take a guess");
        String input = scanner.nextLine();
        return input;
    }

    private String warnInvalidInput(){
        return "Invalid input. Please try again with input of 4 Integers, Example: 1234";
    }

    public void guessStep(String secret){
        String userInput;

        userInput = takeUserInput();

        if(_inputValidator.isValidInput(userInput)){
            matchGuess(userInput, secret);
        }
        else{
            PrintToConsole(warnInvalidInput());
            guessStep(secret);
        }


        if(_scoreCalculator.getBullsCount() == 4){
            PrintToConsole("You guessed the secret. You are a master codebreaker");
        }
    }
    public void runGame() {
        boolean continueGame = true;
        String secret = _secretGenerator.generateSecret();
        while (continueGame) {

            if(DEBUG){
                PrintToConsole(secret);
            }

            guessStep(secret);

            PrintToConsole("Continue game? (0) No (1) Yes (2) Ask computer a hint");
            int select;
            try {
                select = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
               select=0;
            }

            if (select == 0) {
                continueGame = false;
            }
            if (select ==2){
                PrintToConsole("Computer hints :"+ secret.substring(0,2));
            }

        }
    }


    private void PrintToConsole(String display) {
        System.out.println(display);
    }
}
