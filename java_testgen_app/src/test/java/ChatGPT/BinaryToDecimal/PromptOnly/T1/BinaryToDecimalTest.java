package ChatGPT.BinaryToDecimal.PromptOnly.T1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimalWithValidInput() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("1101");
        assertEquals(13, result);
    }

    @Test
    public void testBinaryToDecimalWithZero() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("0");
        assertEquals(0, result);
    }

    @Test
    public void testBinaryToDecimalWithLargeBinaryNumber() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("10101010101010101010");
        assertEquals(2730, result);
    }
}
