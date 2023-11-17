package Copilot.BinaryToDecimal.PromptOnly.T9;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {
    private BinaryToDecimal binaryToDecimal;

    @Before
    public void setUp() {
        binaryToDecimal = new BinaryToDecimal();
    }

    @Test
    public void testConvertToDecimal() {
        assertEquals(4, binaryToDecimal.convertToDecimal("100"));
        assertEquals(5, binaryToDecimal.convertToDecimal("101"));
        assertEquals(6, binaryToDecimal.convertToDecimal("110"));
    }

}