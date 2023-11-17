package Copilot.BinaryToDecimal.PromptOnly.T2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    	BinaryToDecimal converter;

	@Before
	public void setUp() {
		converter = new BinaryToDecimal();
	}

	@Test
	public void testConvertToDecimal() {
		assertEquals(1, converter.convertToDecimal("1"));
		assertEquals(2, converter.convertToDecimal("10"));
		assertEquals(3, converter.convertToDecimal("11"));
		assertEquals(4, converter.convertToDecimal("100"));
		assertEquals(5, converter.convertToDecimal("101"));
		assertEquals(6, converter.convertToDecimal("110"));
		assertEquals(7, converter.convertToDecimal("111"));
		assertEquals(8, converter.convertToDecimal("1000"));
		assertEquals(9, converter.convertToDecimal("1001"));
		assertEquals(10, converter.convertToDecimal("1010"));
		assertEquals(11, converter.convertToDecimal("1011"));
		assertEquals(12, converter.convertToDecimal("1100"));
		assertEquals(13, converter.convertToDecimal("1101"));
		assertEquals(14, converter.convertToDecimal("1110"));
		assertEquals(15, converter.convertToDecimal("1111"));
		assertEquals(16, converter.convertToDecimal("10000"));
		assertEquals(17, converter.convertToDecimal("10001"));
		assertEquals(18, converter.convertToDecimal("10010"));
		assertEquals(19, converter.convertToDecimal("10011"));
		assertEquals(20, converter.convertToDecimal("10100"));
		assertEquals(21, converter.convertToDecimal("10101"));
		assertEquals(22, converter.convertToDecimal("10110"));
		assertEquals(23, converter.convertToDecimal("10111"));
		assertEquals(24, converter.convertToDecimal("11000"));
		assertEquals(25, converter.convertToDecimal("11001"));
		assertEquals(26, converter.convertToDecimal("11010"));
		assertEquals(27, converter.convertToDecimal("11011"));
		assertEquals(28, converter.convertToDecimal("11100"));
		assertEquals(29, converter.convertToDecimal("11101"));
		assertEquals(30, converter.convertToDecimal("11110"));
		assertEquals(31, converter.convertToDecimal("11111"));
		assertEquals(32, converter.convertToDecimal("100000"));
		assertEquals(33, converter.convertToDecimal("100001"));
		assertEquals(34, converter.convertToDecimal("100010"));
		assertEquals(35, converter.convertToDecimal("100011"));
		assertEquals(36, converter.convertToDecimal("100100"));

}