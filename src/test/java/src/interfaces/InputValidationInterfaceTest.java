package src.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.InputValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputValidationInterfaceTest {

    InputValidationInterface _inputValidationInterface = new InputValidator();

    @Test
    @DisplayName("Valid input should be allowed")
    void testValidGuessFormat() {
        assertTrue(_inputValidationInterface.isValidInput("1234"));
    }

    @Test
    @DisplayName("Invalid input should not be allowed if length of input > 4")
    void testInvalidGuessFormatLargeInput() {
        assertFalse(_inputValidationInterface.isValidInput("12345"));
    }

    @Test
    @DisplayName("Invalid input should not be allowed if length of input < 4")
    void testInvalidGuessFormatShortInput() {
        assertFalse(_inputValidationInterface.isValidInput("123"));
    }

    @Test
    @DisplayName("Invalid input should not be allowed if length of input < 4")
    void testInvalidGuessFormatAlphaNumeric() {
        assertFalse(_inputValidationInterface.isValidInput("12z3"));
    }
}