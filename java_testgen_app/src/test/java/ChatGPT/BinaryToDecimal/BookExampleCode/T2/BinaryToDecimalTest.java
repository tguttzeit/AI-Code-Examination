package ChatGPT.BinaryToDecimal.BookExampleCode.T2;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimalWithZero() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("0");
        assertEquals(0, result);
    }

    @Test
    public void testBinaryToDecimalWithOne() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("1");
        assertEquals(1, result);
    }

    @Test
    public void testBinaryToDecimalWithLargeBinaryNumber() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("1101101");
        assertEquals(109, result);
    }

    // Add more test cases as needed
}
