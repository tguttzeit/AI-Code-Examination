package Copilot.BinaryToDecimal.BookExampleCode.T2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testBinaryToDecimal1(){
        BinaryToDecimal b2d = new BinaryToDecimal();
        assertEquals(4, b2d.convertToDecimal("100"));
    }
    @Test
    public void testBinaryToDecimal2(){
        BinaryToDecimal b2d = new BinaryToDecimal();
        assertEquals(0, b2d.convertToDecimal("0"));
    }
    @Test
    public void testBinaryToDecimal3(){
        BinaryToDecimal b2d = new BinaryToDecimal();
        assertEquals(7, b2d.convertToDecimal("111"));
    }

}