package Copilot.BinaryToDecimal.AIGenerated.T9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testConvertToDecimal(){
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        assertEquals(10, binaryToDecimal.convertToDecimal("1010"));
        assertEquals(2, binaryToDecimal.convertToDecimal("10"));
        assertEquals(1, binaryToDecimal.convertToDecimal("1"));
    }

}