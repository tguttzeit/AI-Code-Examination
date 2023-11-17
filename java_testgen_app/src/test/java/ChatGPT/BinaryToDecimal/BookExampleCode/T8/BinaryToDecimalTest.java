package ChatGPT.BinaryToDecimal.BookExampleCode.T8;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {

  @Test
  public void testBinaryToDecimal() {
    BinaryToDecimal converter = new BinaryToDecimal();

    // Test Case 1: Binary '1010' should be converted to decimal 10
    assertEquals(10, converter.convertToDecimal("1010"));

    // Test Case 2: Binary '1101' should be converted to decimal 13
    assertEquals(13, converter.convertToDecimal("1101"));

    // Test Case 3: Binary '11111111' should be converted to decimal 255
    assertEquals(255, converter.convertToDecimal("11111111"));
  }
}
