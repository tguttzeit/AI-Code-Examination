package Copilot.BinaryToDecimal.AIGenerated.T8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testConvertToDecimal1(){
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int decimal = binaryToDecimal.convertToDecimal("101");
        assertEquals(5,decimal);
    }
    @Test
    public void testConvertToDecimal2(){
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int decimal = binaryToDecimal.convertToDecimal("1010");
        assertEquals(10,decimal);
    }
    @Test
    public void testConvertToDecimal3(){
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int decimal = binaryToDecimal.convertToDecimal("10101");
        assertEquals(21,decimal);
    }

}