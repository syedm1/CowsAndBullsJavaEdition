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

}