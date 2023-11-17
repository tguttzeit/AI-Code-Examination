package ChatGPT.BinaryToDecimal.PromptOnly.T4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimalWithValidInput() {
        // Test case 1: Binary "1101" should convert to decimal 13.
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("1101");
        assertEquals(13, result);
    }

    @Test
    public void testBinaryToDecimalWithZeroInput() {
        // Test case 2: Binary "0" should convert to decimal 0.
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("0");
        assertEquals(0, result);
    }

    @Test
    public void testBinaryToDecimalWithInvalidInput() {
        // Test case 3: Binary "10102" is invalid; it contains a non-binary digit '2'.
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();

        // You can choose to handle the exception in your convertToDecimal method
        // or test for it explicitly. Here, we are assuming the method throws an
        // exception.
        try {
            binaryToDecimal.convertToDecimal("10102");
        } catch (IllegalArgumentException e) {
            // We expect an IllegalArgumentException in case of invalid input.
            return; // Test passed
        }

        // If the exception is not thrown, the test fails.
        fail("Expected IllegalArgumentException for invalid input");
    }
}
