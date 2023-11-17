package ChatGPT.BinaryToDecimal.AIGenerated.T3;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinaryToDecimalTest {

    @Test
    public void testConvertToDecimalWithValidBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();

        // Test with a valid binary string "1101"
        int result = converter.convertToDecimal("1101");
        assertEquals(13, result);
    }

    @Test
    public void testConvertToDecimalWithZero() {
        BinaryToDecimal converter = new BinaryToDecimal();

        // Test with binary string "0"
        int result = converter.convertToDecimal("0");
        assertEquals(0, result);
    }

    @Test
    public void testConvertToDecimalWithEmptyString() {
        BinaryToDecimal converter = new BinaryToDecimal();

        // Test with an empty binary string
        int result = converter.convertToDecimal("");
        assertEquals(0, result);
    }
}
