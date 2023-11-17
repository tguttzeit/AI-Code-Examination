package ChatGPT.BinaryToDecimal.PromptOnly.T7;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimalWithValidInput() {
        // Test a valid binary string: "1101"
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("1101");
        assertEquals(13, result);
    }

    @Test
    public void testBinaryToDecimalWithZero() {
        // Test a binary string representing zero: "0"
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("0");
        assertEquals(0, result);
    }

    @Test
    public void testBinaryToDecimalWithInvalidInput() {
        // Test an invalid binary string: "12345"
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        // In this case, the input is not a valid binary string, so the method should return -1 (or another suitable error code).
        int result = binaryToDecimal.convertToDecimal("12345");
        assertEquals(-1, result);
    }
}
