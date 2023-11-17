package Copilot.BinaryToDecimal.AIGenerated.T4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testConvertToDecimal(){
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        assertEquals(binaryToDecimal.convertToDecimal("111"), 7);
    }

    @Test
    public void testConvertToDecimal2(){
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        assertEquals(binaryToDecimal.convertToDecimal("1010"), 10);
    }

    @Test
    public void testConvertToDecimal3(){
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        assertEquals(binaryToDecimal.convertToDecimal("101010"), 42);
    }

}