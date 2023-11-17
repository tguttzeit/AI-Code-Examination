package Copilot.BinaryToDecimal.BookExampleCode.T5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void test1(){
        BinaryToDecimal btd = new BinaryToDecimal();
        assertEquals(0,btd.convertToDecimal("0"));
    }
    @Test
    public void test2(){
        BinaryToDecimal btd = new BinaryToDecimal();
        assertEquals(1,btd.convertToDecimal("1"));
    }
    @Test
    public void test3(){
        BinaryToDecimal btd = new BinaryToDecimal();
        assertEquals(2,btd.convertToDecimal("10"));
    }

}