package ChatGPT.BinaryToDecimal.AIGenerated.T5;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {

    @Test
    public void testConvertToDecimalWithValidBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();
        String binary = "1101";
        int expectedDecimal = 13;
        int actualDecimal = converter.convertToDecimal(binary);
        assertEquals(expectedDecimal, actualDecimal);
    }

    @Test
    public void testConvertToDecimalWithZero() {
        BinaryToDecimal converter = new BinaryToDecimal();
        String binary = "0";
        int expectedDecimal = 0;
        int actualDecimal = converter.convertToDecimal(binary);
        assertEquals(expectedDecimal, actualDecimal);
    }

    @Test
    public void testConvertToDecimalWithInvalidBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();
        String binary = "1012"; // This is not a valid binary string.
        try {
            int decimal = converter.convertToDecimal(binary);
        } catch (NumberFormatException e) {
            // Expecting a NumberFormatException when the input is invalid.
            return; // Test passed
        }
        // If we don't catch an exception, the test fails.
        fail("Expected NumberFormatException for invalid binary input");
    }
}
