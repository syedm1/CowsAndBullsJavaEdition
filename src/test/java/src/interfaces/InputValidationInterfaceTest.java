package src.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.core.InputValidator;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Given a character guess there should be a NumberFormatException")
    void testBadInput() {
        assertThrows(NumberFormatException.class, () -> {
            _inputValidationInterface.extractInteger("abcd");
        });
    }

    @Test
    @DisplayName("Given a empty guess there should be a NumberFormatException")
    void testEmptyInput() {
        assertThrows(NumberFormatException.class, () -> {
            _inputValidationInterface.extractInteger("");
        });
    }

}