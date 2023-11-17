package ChatGPT.BinaryToDecimal.BookExampleCode.T7;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimalConversionWithZero() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("0");
        assertEquals(0, result);
    }

    @Test
    public void testBinaryToDecimalConversionWithPositiveNumber() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("10101");
        assertEquals(21, result);
    }

    @Test
    public void testBinaryToDecimalConversionWithLargeNumber() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("110110011110101");
        assertEquals(8629, result);
    }
}
