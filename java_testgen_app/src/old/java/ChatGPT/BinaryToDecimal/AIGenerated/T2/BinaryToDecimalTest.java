package ChatGPT.BinaryToDecimal.AIGenerated.T2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {

    @Test
    public void testConvertToDecimalWithValidBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();
        String binary = "1101";
        int expectedDecimal = 13;
        int actualDecimal = converter.convertToDecimal(binary);
        assertEquals(expectedDecimal, actualDecimal);
    }

    @Test
    public void testConvertToDecimalWithZeroBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();
        String binary = "0";
        int expectedDecimal = 0;
        int actualDecimal = converter.convertToDecimal(binary);
        assertEquals(expectedDecimal, actualDecimal);
    }

    @Test
    public void testConvertToDecimalWithEmptyBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();
        String binary = "";
        // Since the input is empty, it should throw a NumberFormatException
        try {
            converter.convertToDecimal(binary);
        } catch (NumberFormatException e) {
            // We expect an exception to be thrown
            return;
        }
        // If an exception is not thrown, the test should fail
        fail("Expected NumberFormatException, but no exception was thrown");
    }
}
