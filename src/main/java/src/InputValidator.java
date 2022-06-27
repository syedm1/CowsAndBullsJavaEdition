package src;

import src.interfaces.InputValidationInterface;

import static src.Utils.isInteger;

public class InputValidator implements InputValidationInterface {
    private final int USER_GUESS_LENGTH = 4;

    @Override
    public boolean isValidInput(String text) {
        return text.length() == USER_GUESS_LENGTH && isInteger(text);
    }
}
