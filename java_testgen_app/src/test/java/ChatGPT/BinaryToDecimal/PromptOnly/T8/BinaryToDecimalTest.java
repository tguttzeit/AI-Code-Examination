package ChatGPT.BinaryToDecimal.PromptOnly.T8;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {

    @Test
    public void testConvertToDecimal_ValidBinary() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("1010");
        assertEquals(10, result);
    }

    @Test
    public void testConvertToDecimal_BinaryWithLeadingZeros() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("001100");
        assertEquals(12, result);
    }

    @Test
    public void testConvertToDecimal_BinaryWithZerosAndOnes() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("1101101");
        assertEquals(109, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertToDecimal_InvalidBinary() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        binaryToDecimal.convertToDecimal("12345"); // This should throw an exception
    }
}
