package ChatGPT.BinaryToDecimal.AIGenerated.T4;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {

    @Test
    public void testConvertToDecimalWithValidBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();

        // Test case 1: Binary "1010" should convert to decimal 10
        assertEquals(10, converter.convertToDecimal("1010"));

        // Test case 2: Binary "1101101" should convert to decimal 109
        assertEquals(109, converter.convertToDecimal("1101101"));

        // Test case 3: Binary "1111" should convert to decimal 15
        assertEquals(15, converter.convertToDecimal("1111"));
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertToDecimalWithInvalidBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();

        // Test case 4: Invalid binary "12345" should throw NumberFormatException
        converter.convertToDecimal("12345");
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertToDecimalWithEmptyBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();

        // Test case 5: Empty binary string should throw NumberFormatException
        converter.convertToDecimal("");
    }
}
