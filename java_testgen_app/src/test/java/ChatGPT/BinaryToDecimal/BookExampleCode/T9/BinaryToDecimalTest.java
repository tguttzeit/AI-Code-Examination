package ChatGPT.BinaryToDecimal.BookExampleCode.T9;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryToDecimalTest {

  @Test
  public void testBinaryToDecimalWithZero() {
    BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
    int result = binaryToDecimal.convertToDecimal("0");
    assertEquals(0, result);
  }

  @Test
  public void testBinaryToDecimalWithBinaryOne() {
    BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
    int result = binaryToDecimal.convertToDecimal("1");
    assertEquals(1, result);
  }

  @Test
  public void testBinaryToDecimalWithBinaryNumber() {
    BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
    int result = binaryToDecimal.convertToDecimal("1101");
    assertEquals(13, result);
  }
}
