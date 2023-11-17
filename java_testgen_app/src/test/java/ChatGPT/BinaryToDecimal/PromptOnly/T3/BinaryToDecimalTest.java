package ChatGPT.BinaryToDecimal.PromptOnly.T3;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {

    @Test
    public void testConvertToDecimal_PositiveBinary() {
        // Arrange
        String binary = "1101";
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();

        // Act
        int result = binaryToDecimal.convertToDecimal(binary);

        // Assert
        assertEquals(13, result);
    }

    @Test
    public void testConvertToDecimal_ZeroBinary() {
        // Arrange
        String binary = "0";
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();

        // Act
        int result = binaryToDecimal.convertToDecimal(binary);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testConvertToDecimal_NegativeBinary() {
        // Arrange
        String binary = "-1010"; // This is not a valid binary string.
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();

        // Act & Assert
        try {
            binaryToDecimal.convertToDecimal(binary);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("Invalid binary string", e.getMessage());
        }
    }
}
