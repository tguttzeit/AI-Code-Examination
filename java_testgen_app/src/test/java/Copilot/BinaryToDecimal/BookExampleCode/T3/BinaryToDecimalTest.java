package Copilot.BinaryToDecimal.BookExampleCode.T3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testBinaryToDecimal1(){
        BinaryToDecimal btd = new BinaryToDecimal();
        assertEquals(1, btd.convertToDecimal("1"));
    }
    @Test
    public void testBinaryToDecimal2(){
        BinaryToDecimal btd = new BinaryToDecimal();
        assertEquals(2, btd.convertToDecimal("10"));
    }
    @Test
    public void testBinaryToDecimal3(){
        BinaryToDecimal btd = new BinaryToDecimal();
        assertEquals(3, btd.convertToDecimal("11"));
    }

}