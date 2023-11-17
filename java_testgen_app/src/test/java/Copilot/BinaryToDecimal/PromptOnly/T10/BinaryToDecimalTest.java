package Copilot.BinaryToDecimal.PromptOnly.T10;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    private BinaryToDecimal binaryToDecimal;

    @Before
    public void setUp() {
        binaryToDecimal = new BinaryToDecimal();
    }

    @Test
    public void testConvertToDecimal() {
        assertEquals(1, binaryToDecimal.convertToDecimal("1"));
        assertEquals(2, binaryToDecimal.convertToDecimal("10"));
        assertEquals(3, binaryToDecimal.convertToDecimal("11"));
        assertEquals(4, binaryToDecimal.convertToDecimal("100"));
        assertEquals(5, binaryToDecimal.convertToDecimal("101"));
        assertEquals(6, binaryToDecimal.convertToDecimal("110"));
        assertEquals(7, binaryToDecimal.convertToDecimal("111"));
        assertEquals(8, binaryToDecimal.convertToDecimal("1000"));
        assertEquals(9, binaryToDecimal.convertToDecimal("1001"));
        assertEquals(10, binaryToDecimal.convertToDecimal("1010"));
        assertEquals(11, binaryToDecimal.convertToDecimal("1011"));
        assertEquals(12, binaryToDecimal.convertToDecimal("1100"));
        assertEquals(13, binaryToDecimal.convertToDecimal("1101"));
        assertEquals(14, binaryToDecimal.convertToDecimal("1110"));
        assertEquals(15, binaryToDecimal.convertToDecimal("1111"));
        assertEquals(16, binaryToDecimal.convertToDecimal("10000"));
    }

}