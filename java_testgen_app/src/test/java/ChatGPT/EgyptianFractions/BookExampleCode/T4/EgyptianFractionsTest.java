package ChatGPT.EgyptianFractions.BookExampleCode.T4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EgyptianFractionsTest {

    @Test
    public void testSimpleFraction() {
        EgyptianFractions fractions = new EgyptianFractions();
        Long numerator = 2L;
        Long denominator = 5L;
        // Expected result: [3, 10]
        assertEquals("[3, 10]", fractions.build(numerator, denominator).toString());
    }

    @Test
    public void testWholeNumber() {
        EgyptianFractions fractions = new EgyptianFractions();
        Long numerator = 3L;
        Long denominator = 1L;
        // Expected result: [3]
        assertEquals("[3]", fractions.build(numerator, denominator).toString());
    }

    @Test
    public void testZeroNumerator() {
        EgyptianFractions fractions = new EgyptianFractions();
        Long numerator = 0L;
        Long denominator = 7L;
        // Expected result: []
        assertEquals("[]", fractions.build(numerator, denominator).toString());
    }
}
