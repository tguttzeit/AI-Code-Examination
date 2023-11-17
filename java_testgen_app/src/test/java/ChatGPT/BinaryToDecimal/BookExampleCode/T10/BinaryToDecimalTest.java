package ChatGPT.BinaryToDecimal.BookExampleCode.T10;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimalWithZero() {
        BinaryToDecimal converter = new BinaryToDecimal();
        String binary = "0";
        int expected = 0;
        int actual = converter.convertToDecimal(binary);
        assertEquals(expected, actual);
    }

    @Test
    public void testBinaryToDecimalWithOne() {
        BinaryToDecimal converter = new BinaryToDecimal();
        String binary = "1";
        int expected = 1;
        int actual = converter.convertToDecimal(binary);
        assertEquals(expected, actual);
    }

    @Test
    public void testBinaryToDecimalWithLargeNumber() {
        BinaryToDecimal converter = new BinaryToDecimal();
        String binary = "1010101";
        int expected = 85;
        int actual = converter.convertToDecimal(binary);
        assertEquals(expected, actual);
    }

    @Test
    public void testBinaryToDecimalWithInvalidBinary() {
        BinaryToDecimal converter = new BinaryToDecimal();
        String binary = "10102"; // Invalid binary string
        // You can add assertions for expected error handling here if your code has error handling logic
        // For simplicity, we are not including it in this example.
        // Example: assertThrows(Exception.class, () -> converter.convertToDecimal(binary));
    }
}
