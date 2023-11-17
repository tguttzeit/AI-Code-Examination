package ChatGPT.BinaryToDecimal.PromptOnly.T5;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {

    @Test
    public void testConvertToDecimalWithValidBinary() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("1010");
        assertEquals(10, result);
    }

    @Test
    public void testConvertToDecimalWithZeroBinary() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("0");
        assertEquals(0, result);
    }

    @Test
    public void testConvertToDecimalWithInvalidBinary() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("12345"); // Invalid binary
        assertEquals(-1, result); // Assuming -1 indicates an error or invalid input
    }
}
