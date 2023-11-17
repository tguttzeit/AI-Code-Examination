package Copilot.BinaryToDecimal.AIGenerated.T10;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testBinaryToDecimal(){
        BinaryToDecimal btd = new BinaryToDecimal();
        int result = btd.convertToDecimal("1001");
        assertEquals(9, result);
    }

    @Test
    public void testBinaryToDecimal2(){
        BinaryToDecimal btd = new BinaryToDecimal();
        int result = btd.convertToDecimal("1010");
        assertEquals(10, result);
    }

    @Test
    public void testBinaryToDecimal3(){
        BinaryToDecimal btd = new BinaryToDecimal();
        int result = btd.convertToDecimal("1011");
        assertEquals(11, result);
    }

}