package Copilot.BinaryToDecimal.BookExampleCode.T1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void binaryToDecimalTest1(){
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("0000");
        assertEquals(0, result);
    }

    @Test
    public void binaryToDecimalTest2(){
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("0001");
        assertEquals(1, result);
    }

    @Test
    public void binaryToDecimalTest3(){
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int result = binaryToDecimal.convertToDecimal("1111");
        assertEquals(15, result);
    }

}