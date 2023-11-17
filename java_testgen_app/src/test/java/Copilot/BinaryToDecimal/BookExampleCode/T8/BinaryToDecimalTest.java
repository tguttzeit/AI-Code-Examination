package Copilot.BinaryToDecimal.BookExampleCode.T8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {

    @Test
    public void testConvertToDecimal(){
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        assertEquals(1, binaryToDecimal.convertToDecimal("1"));
        assertEquals(2, binaryToDecimal.convertToDecimal("10"));
        assertEquals(3, binaryToDecimal.convertToDecimal("11"));
    }
}