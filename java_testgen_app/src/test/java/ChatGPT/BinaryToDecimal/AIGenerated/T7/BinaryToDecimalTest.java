package ChatGPT.BinaryToDecimal.AIGenerated.T7;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimalPositiveCase() {
        BinaryToDecimal converter = new BinaryToDecimal();
        int decimal = converter.convertToDecimal("1010");
        assertEquals(10, decimal);
    }

    @Test
    public void testBinaryToDecimalZero() {
        BinaryToDecimal converter = new BinaryToDecimal();
        int decimal = converter.convertToDecimal("0");
        assertEquals(0, decimal);
    }

    @Test
    public void testBinaryToDecimalLargeBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();
        int decimal = converter.convertToDecimal("110110110101011010101011");
        assertEquals(9098939, decimal);
    }
}
