package ChatGPT.BinaryToDecimal.AIGenerated.T10;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinaryToDecimalTest {
    private BinaryToDecimal binaryToDecimal;

    @Before
    public void setUp() {
        binaryToDecimal = new BinaryToDecimal();
    }

    @Test
    public void testBinaryToDecimal() {
        // Test case 1: Binary "101" should convert to decimal 5
        assertEquals(5, binaryToDecimal.convertToDecimal("101"));

        // Test case 2: Binary "1101" should convert to decimal 13
        assertEquals(13, binaryToDecimal.convertToDecimal("1101"));

        // Test case 3: Binary "11111" should convert to decimal 31
        assertEquals(31, binaryToDecimal.convertToDecimal("11111"));
    }
}
