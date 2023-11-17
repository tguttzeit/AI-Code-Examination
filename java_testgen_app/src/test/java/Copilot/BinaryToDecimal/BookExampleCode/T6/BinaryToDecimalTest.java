package Copilot.BinaryToDecimal.BookExampleCode.T6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void test1(){
        BinaryToDecimal test = new BinaryToDecimal();
        assertEquals(test.convertToDecimal("111"), 7);
    }
    @Test
    public void test2(){
        BinaryToDecimal test = new BinaryToDecimal();
        assertEquals(test.convertToDecimal("110001"), 49);
    }
    @Test
    public void test3(){
        BinaryToDecimal test = new BinaryToDecimal();
        assertEquals(test.convertToDecimal("101010"), 42);
    }

}