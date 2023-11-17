package ChatGPT.BinaryToDecimal.AIGenerated.T1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {
    private BinaryToDecimal converter;

    @Before
    public void setUp() {
        converter = new BinaryToDecimal();
    }

    @Test
    public void testBinaryToDecimalPositive() {
        // Test converting a positive binary number to decimal
        String binary = "1101";
        int expectedDecimal = 13;
        int actualDecimal = converter.convertToDecimal(binary);
        assertEquals(expectedDecimal, actualDecimal);
    }

    @Test
    public void testBinaryToDecimalZero() {
        // Test converting binary "0" to decimal
        String binary = "0";
        int expectedDecimal = 0;
        int actualDecimal = converter.convertToDecimal(binary);
        assertEquals(expectedDecimal, actualDecimal);
    }

    @Test
    public void testBinaryToDecimalNegative() {
        // Test converting a negative binary number to decimal
        String binary = "-1010"; // This should not be a valid binary string
        try {
            int actualDecimal = converter.convertToDecimal(binary);
            fail("Expected NumberFormatException, but got: " + actualDecimal);
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }
}
