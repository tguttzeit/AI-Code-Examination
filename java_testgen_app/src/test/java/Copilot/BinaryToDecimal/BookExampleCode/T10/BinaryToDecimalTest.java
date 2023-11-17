package Copilot.BinaryToDecimal.BookExampleCode.T10;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testConvertToDecimal() {
        BinaryToDecimal test = new BinaryToDecimal();
        assertEquals(5, test.convertToDecimal("101"));
        assertEquals(8, test.convertToDecimal("1000"));
        assertEquals(9, test.convertToDecimal("1001"));
    }

}