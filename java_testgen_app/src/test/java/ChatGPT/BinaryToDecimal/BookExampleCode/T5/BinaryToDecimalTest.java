package ChatGPT.BinaryToDecimal.BookExampleCode.T5;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryToDecimalTest {

  @Test
  public void testBinaryToDecimalConversion1() {
    BinaryToDecimal converter = new BinaryToDecimal();
    String binary = "1101";
    int expectedResult = 13;
    int result = converter.convertToDecimal(binary);
    assertEquals(expectedResult, result);
  }

  @Test
  public void testBinaryToDecimalConversion2() {
    BinaryToDecimal converter = new BinaryToDecimal();
    String binary = "101010";
    int expectedResult = 42;
    int result = converter.convertToDecimal(binary);
    assertEquals(expectedResult, result);
  }

  @Test
  public void testBinaryToDecimalConversion3() {
    BinaryToDecimal converter = new BinaryToDecimal();
    String binary = "11111111";
    int expectedResult = 255;
    int result = converter.convertToDecimal(binary);
    assertEquals(expectedResult, result);
  }
}
