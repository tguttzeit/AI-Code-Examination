package Copilot.BinaryToDecimal.AIGenerated.T6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testBinaryToDecimal() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("111");
        assertEquals(7, result);
    }

    @Test
    public void testBinaryToDecimal2() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("101");
        assertEquals(5, result);
    }

    @Test
    public void testBinaryToDecimal3() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("1010");
        assertEquals(10, result);
    }


}