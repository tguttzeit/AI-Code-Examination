package Copilot.BinaryToDecimal.PromptOnly.T4;

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
	public void test1() {
		assertEquals(0, btd.convertToDecimal("0"));
	}

	@Test
	public void test2() {
		assertEquals(1, btd.convertToDecimal("1"));
	}

	@Test
	public void test3() {
		assertEquals(2, btd.convertToDecimal("10"));
	}

	@Test
	public void test4() {
		assertEquals(3, btd.convertToDecimal("11"));
	}

	@Test
	public void test5() {
		assertEquals(4, btd.convertToDecimal("100"));
	}

	@Test
	public void test6() {
		assertEquals(5, btd.convertToDecimal("101"));
	}

	@Test
	public void test7() {
		assertEquals(6, btd.convertToDecimal("110"));
	}

	@Test
	public void test8() {
		assertEquals(7, btd.convertToDecimal("111"));
	}

	@Test
	public void test9() {
		assertEquals(8, btd.convertToDecimal("1000"));
	}

	@Test
	public void test10() {
		assertEquals(9, btd.convertToDecimal("1001"));
	}

	@Test
	public void test11() {
		assertEquals(10, btd.convertToDecimal("1010"));
	}

	@Test
	public void test12() {
		assertEquals(11, btd.convertToDecimal("1011"));
	}

	@Test
	public void test13() {
		assertEquals(12, btd.convertToDecimal("1100"));
	}

	@Test
	public void test14() {
		assertEquals(13, btd.convertToDecimal("1101"));
	}

	@Test
	public void test15() {
		assertEquals(14, btd.convertToDecimal("1110"));
	}

	@Test
	public void test16() {
		assertEquals(15, btd.convertToDecimal("1111"));
	}

	@Test
	public void test17() {
		assertEquals(16, btd.convertToDecimal("10000"));
	}

	@Test
	public void test18() {
		assertEquals(17, btd.convertToDecimal("10001"));
	}

	@Test
	public void test19() {
		assertEquals

}