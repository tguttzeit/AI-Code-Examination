package ChatGPT.BinaryToDecimal.PromptOnly.T9;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinaryToDecimalTest {

    @Test
    public void testConvertToDecimalWithValidBinary() {
        BinaryToDecimal binaryConverter = new BinaryToDecimal();
        int result = binaryConverter.convertToDecimal("1010");
        assertEquals(10, result);
    }

    @Test
    public void testConvertToDecimalWithZeroBinary() {
        BinaryToDecimal binaryConverter = new BinaryToDecimal();
        int result = binaryConverter.convertToDecimal("0");
        assertEquals(0, result);
    }

    @Test
    public void testConvertToDecimalWithLeadingZeros() {
        BinaryToDecimal binaryConverter = new BinaryToDecimal();
        int result = binaryConverter.convertToDecimal("0011001");
        assertEquals(25, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertToDecimalWithInvalidBinary() {
        BinaryToDecimal binaryConverter = new BinaryToDecimal();
        binaryConverter.convertToDecimal("1234"); // This should throw an exception
    }
}
