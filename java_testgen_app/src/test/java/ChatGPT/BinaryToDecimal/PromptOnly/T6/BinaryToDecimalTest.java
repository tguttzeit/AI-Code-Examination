package ChatGPT.BinaryToDecimal.PromptOnly.T6;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinaryToDecimalTest {

    @Test
    public void testConvertToDecimal_ValidBinaryString() {
        BinaryToDecimal converter = new BinaryToDecimal();
        assertEquals(5, converter.convertToDecimal("101"));
    }

    @Test
    public void testConvertToDecimal_BinaryStringWithLeadingZeros() {
        BinaryToDecimal converter = new BinaryToDecimal();
        assertEquals(3, converter.convertToDecimal("0011"));
    }

    @Test
    public void testConvertToDecimal_EmptyBinaryString() {
        BinaryToDecimal converter = new BinaryToDecimal();
        assertEquals(0, converter.convertToDecimal(""));
    }
}
