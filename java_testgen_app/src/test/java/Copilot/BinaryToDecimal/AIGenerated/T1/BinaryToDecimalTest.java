package Copilot.BinaryToDecimal.AIGenerated.T1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    @Test
    public void testConvertToDecimal() {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int decimal = binaryToDecimal.convertToDecimal("1101");
        assertEquals(13, decimal);
    }

}