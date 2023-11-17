package Copilot.BinaryToDecimal.AIGenerated.T3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testConvertToDecimal() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        assertEquals(1, binaryToDecimal.convertToDecimal("1"));
    }

    @Test
    public void testConvertToDecimal2() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        assertEquals(2, binaryToDecimal.convertToDecimal("10"));
    }

    @Test
    public void testConvertToDecimal3() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        assertEquals(3, binaryToDecimal.convertToDecimal("11"));
    }

}