package ChatGPT.BinaryToDecimal.BookExampleCode.T4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimal() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();

        // Test case 1: Binary 1101 should be decimal 13
        assertEquals(13, binaryToDecimal.convertToDecimal("1101"));

        // Test case 2: Binary 101010 should be decimal 42
        assertEquals(42, binaryToDecimal.convertToDecimal("101010"));

        // Test case 3: Binary 111111 should be decimal 63
        assertEquals(63, binaryToDecimal.convertToDecimal("111111"));
    }
}
