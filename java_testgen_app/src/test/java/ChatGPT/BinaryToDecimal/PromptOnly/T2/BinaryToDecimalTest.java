package ChatGPT.BinaryToDecimal.PromptOnly.T2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimalConversion() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();

        // Test Case 1: Binary "1010" should convert to decimal 10
        assertEquals(10, binaryToDecimal.convertToDecimal("1010"));

        // Test Case 2: Binary "1101" should convert to decimal 13
        assertEquals(13, binaryToDecimal.convertToDecimal("1101"));

        // Test Case 3: Binary "11111" should convert to decimal 31
        assertEquals(31, binaryToDecimal.convertToDecimal("11111"));
    }
}
