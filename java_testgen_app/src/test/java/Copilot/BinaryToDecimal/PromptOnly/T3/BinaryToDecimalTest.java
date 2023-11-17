package Copilot.BinaryToDecimal.PromptOnly.T3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    BinaryToDecimal btd;

    @Before
    public void setUp() {
        btd = new BinaryToDecimal();
    }

    @Test
    public void testConvertToDecimal() {
        assertEquals(0, btd.convertToDecimal("0"));
        assertEquals(1, btd.convertToDecimal("1"));
        assertEquals(2, btd.convertToDecimal("10"));
        assertEquals(3, btd.convertToDecimal("11"));
        assertEquals(4, btd.convertToDecimal("100"));
        assertEquals(5, btd.convertToDecimal("101"));
        assertEquals(6, btd.convertToDecimal("110"));
        assertEquals(7, btd.convertToDecimal("111"));
        assertEquals(8, btd.convertToDecimal("1000"));
        assertEquals(9, btd.convertToDecimal("1001"));
        assertEquals(10, btd.convertToDecimal("1010"));
        assertEquals(11, btd.convertToDecimal("1011"));
        assertEquals(12, btd.convertToDecimal("1100"));
        assertEquals(13, btd.convertToDecimal("1101"));
        assertEquals(14, btd.convertToDecimal("1110"));
        assertEquals(15, btd.convertToDecimal("1111"));
        assertEquals(16, btd.convertToDecimal("10000"));
    }

}