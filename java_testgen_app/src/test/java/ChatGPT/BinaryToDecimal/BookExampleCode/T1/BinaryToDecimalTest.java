package ChatGPT.BinaryToDecimal.BookExampleCode.T1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimalWithZero() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        String binary = "0";
        int expected = 0;
        int actual = binaryToDecimal.convertToDecimal(binary);
        assertEquals(expected, actual);
    }

    @Test
    public void testBinaryToDecimalWithPositiveNumber() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        String binary = "1101";
        int expected = 13;
        int actual = binaryToDecimal.convertToDecimal(binary);
        assertEquals(expected, actual);
    }

    @Test
    public void testBinaryToDecimalWithLargeNumber() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        String binary = "1010101010101010";
        int expected = 43690; // This binary represents 2^0 + 2^2 + 2^4 + 2^6 + 2^8 + 2^10 + 2^12 + 2^14
        int actual = binaryToDecimal.convertToDecimal(binary);
        assertEquals(expected, actual);
    }
}
