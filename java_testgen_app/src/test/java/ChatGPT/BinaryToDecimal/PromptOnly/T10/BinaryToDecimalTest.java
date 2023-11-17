package ChatGPT.BinaryToDecimal.PromptOnly.T10;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {
    private BinaryToDecimal binaryToDecimal;

    @Before
    public void setUp() {
        binaryToDecimal = new BinaryToDecimal();
    }

    @Test
    public void testBinaryToDecimal_PositiveCase() {
        // Test a binary number that should convert to 10 in decimal.
        int decimal = binaryToDecimal.convertToDecimal("1010");
        assertEquals(10, decimal);
    }

    @Test
    public void testBinaryToDecimal_ZeroBinary() {
        // Test binary number "0", which should convert to 0 in decimal.
        int decimal = binaryToDecimal.convertToDecimal("0");
        assertEquals(0, decimal);
    }

    @Test
    public void testBinaryToDecimal_MaxBinary() {
        // Test a large binary number "1111111111", which should convert to 1023 in decimal.
        int decimal = binaryToDecimal.convertToDecimal("1111111111");
        assertEquals(1023, decimal);
    }
}
