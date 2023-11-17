package Copilot.BinaryToDecimal.PromptOnly.T5;

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
        assertEquals(17, binaryToDecimal.convertToDecimal("10001"));
        assertEquals(18, binaryToDecimal.convertToDecimal("10010"));
        assertEquals(19, binaryToDecimal.convertToDecimal("10011"));
        assertEquals(20, binaryToDecimal.convertToDecimal("10100"));
        assertEquals(21, binaryToDecimal.convertToDecimal("10101"));
        assertEquals(22, binaryToDecimal.convertToDecimal("10110"));
        assertEquals(23, binaryToDecimal.convertToDecimal("10111"));
        assertEquals(24, binaryToDecimal.convertToDecimal("11000"));
        assertEquals(25, binaryToDecimal.convertToDecimal("11001"));
        assertEquals(26, binaryToDecimal.convertToDecimal("11010"));
        assertEquals(27, binaryToDecimal.convertToDecimal("11011"));
        assertEquals(28, binaryToDecimal.convertToDecimal("11100"));
        assertEquals(29, binaryToDecimal.convertToDecimal("11101"));
        assertEquals(30, binaryToDecimal.convertToDecimal("11110"));
        assertEquals(31, binaryToDecimal.convertToDecimal("11111"));
        assertEquals(32, binaryToDecimal.convertToDecimal("100000"));
        assertEquals(33, binaryToDecimal.convertToDecimal("100001"));
    }

}