package ChatGPT.BinaryToDecimal.AIGenerated.T9;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimalPositive() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();

        // Test case 1: Binary '1010' should convert to decimal 10
        int result1 = binaryToDecimal.convertToDecimal("1010");
        assertEquals(10, result1);

        // Test case 2: Binary '1101' should convert to decimal 13
        int result2 = binaryToDecimal.convertToDecimal("1101");
        assertEquals(13, result2);

        // Test case 3: Binary '11111111' (8 bits) should convert to decimal 255
        int result3 = binaryToDecimal.convertToDecimal("11111111");
        assertEquals(255, result3);
    }

    @Test
    public void testBinaryToDecimalEdgeCases() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();

        // Test case 4: Binary '0' should convert to decimal 0
        int result4 = binaryToDecimal.convertToDecimal("0");
        assertEquals(0, result4);

        // Test case 5: Binary '1' should convert to decimal 1
        int result5 = binaryToDecimal.convertToDecimal("1");
        assertEquals(1, result5);
    }

    @Test(expected = NumberFormatException.class)
    public void testBinaryToDecimalInvalidInput() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();

        // Test case 6: Invalid binary input should throw NumberFormatException
        binaryToDecimal.convertToDecimal("1023");
    }
}
