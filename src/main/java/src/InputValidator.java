package src;

import src.interfaces.InputValidationInterface;

import static src.Utils.isInteger;

public class InputValidator implements InputValidationInterface {

    @Override
    public boolean isValidInput(String text) {
        return text.length()==4 && isInteger(text);
    }
}
