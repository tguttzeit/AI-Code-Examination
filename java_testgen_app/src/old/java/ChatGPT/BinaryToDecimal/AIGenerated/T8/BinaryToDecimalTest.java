package ChatGPT.BinaryToDecimal.AIGenerated.T8;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimalWithValidBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();
        int result = converter.convertToDecimal("1101");
        assertEquals(13, result);
    }

    @Test
    public void testBinaryToDecimalWithZero() {
        BinaryToDecimal converter = new BinaryToDecimal();
        int result = converter.convertToDecimal("0");
        assertEquals(0, result);
    }

    @Test
    public void testBinaryToDecimalWithLargeBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();
        int result = converter.convertToDecimal("1101101010101010110101101010101011010101010101101");
        assertEquals(2342342342342342345, result);
    }
}
