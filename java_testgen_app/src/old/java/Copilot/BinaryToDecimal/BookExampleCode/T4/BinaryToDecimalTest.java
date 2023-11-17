package Copilot.BinaryToDecimal.BookExampleCode.T4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testConvertToDecimal(){
        BinaryToDecimal btd = new BinaryToDecimal();
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
        assertEquals(17, btd.convertToDecimal("10001"));
        assertEquals(18, btd.convertToDecimal("10010"));
        assertEquals(19, btd.convertToDecimal("10011"));
        assertEquals(20, btd.convertToDecimal("10100"));
        assertEquals(21, btd.convertToDecimal("10101"));
        assertEquals(22, btd.convertToDecimal("10110"));
        assertEquals(23, btd.convertToDecimal("10111"));
        assertEquals(24, btd.convertToDecimal("11000"));
        assertEquals(25, btd.convertToDecimal("11001"));
        assertEquals(26, btd.convertToDecimal("11010"));
        assertEquals(27, btd.convertToDecimal("11011"));
        assertEquals(28, btd.convertToDecimal("11100"));
        assertEquals(29, btd.convertToDecimal("11101"));
        assertEquals(30, btd.convertToDecimal("11110"));
        assertEquals(31, btd.convertToDecimal("11111"));
        assertEquals(32, btd.convertToDecimal("100000"));
        assertEquals(33, btd.convertToDecimal("100001"));
        assertEquals(34, btd

}