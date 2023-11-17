package ChatGPT.BinaryToDecimal.AIGenerated.T6;

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
    public void testBinaryToDecimalWithPositiveNumber() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("101010");
        assertEquals(42, result);
    }

    @Test
    public void testBinaryToDecimalWithLargeBinaryNumber() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("1111111111");
        assertEquals(1023, result);
    }
}
