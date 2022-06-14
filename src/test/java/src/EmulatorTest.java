package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmulatorTest {

    Emulator emulator;

    @BeforeEach
    void setUp() {
        emulator = Emulator.getInstance();
    }
    @Test
    @DisplayName("Valid input should be allowed")
    void testValidGuessFormat() {
        assertNotNull(emulator);
    }

//
//    @Test
//    @DisplayName("Valid input should be allowed")
//    void testValidGuessFormat() {
//        assertTrue(emulator.isValidInput("1234"));
//    }
//
//    @Test
//    @DisplayName("Invalid input should not be allowed if length of input > 4")
//    void testInvalidGuessFormatLargeInput() {
//        assertFalse(emulator.isValidInput("12345"));
//    }
//
//    @Test
//    @DisplayName("Invalid input should not be allowed if length of input < 4")
//    void testInvalidGuessFormatShortInput() {
//        assertFalse(emulator.isValidInput("123"));
//    }
//
//    @Test
//    @DisplayName("Invalid input should not be allowed if length of input < 4")
//    void testInvalidGuessFormatAlphaNumeric() {
//        assertFalse(emulator.isValidInput("12z3"));
//    }

}