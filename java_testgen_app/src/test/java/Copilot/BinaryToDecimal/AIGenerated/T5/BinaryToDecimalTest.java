package Copilot.BinaryToDecimal.AIGenerated.T5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testConvertToDecimal() {
        BinaryToDecimal btd = new BinaryToDecimal();
        assertEquals(1, btd.convertToDecimal("1"));
        assertEquals(2, btd.convertToDecimal("10"));
        assertEquals(3, btd.convertToDecimal("11"));
    }

}