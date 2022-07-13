package src.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.core.SecretGenerator;
import src.models.ScoreDetails;

import static org.junit.jupiter.api.Assertions.*;
import static src.Utils.isInteger;

class SecretGeneratorInterfaceTest {
    SecretGeneratorInterface secretGeneratorInterface;

    @BeforeEach
    void setUp() {
        secretGeneratorInterface = new SecretGenerator();
    }

    @Test
    @DisplayName("Generate a valid secret")
    void testValidSecret() {
        String secret = secretGeneratorInterface.generateSecret();
        assertNotNull(secret);
    }

    @Test
    @DisplayName("Generate a secret with digits only")
    void checkSecretType() {
        String secret = secretGeneratorInterface.generateSecret();
        assertTrue(isInteger(secret));
    }
}