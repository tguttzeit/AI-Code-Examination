package ChatGPT.EgyptianFractions.PromptOnly.T5;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class EgyptianFractionsTest {

    @Test
    public void testBuildWithProperFraction() {
        EgyptianFractions fractions = new EgyptianFractions();
        Long numerator = 3L;
        Long denominator = 4L;
        List<Long> result = fractions.build(numerator, denominator);
        // Verify that the result is [1, 2, 4]
        assertArrayEquals(new Long[] { 1L, 2L, 4L }, result.toArray());
    }

    @Test
    public void testBuildWithImproperFraction() {
        EgyptianFractions fractions = new EgyptianFractions();
        Long numerator = 5L;
        Long denominator = 3L;
        List<Long> result = fractions.build(numerator, denominator);
        // Verify that the result is [2, 4, 12]
        assertArrayEquals(new Long[] { 2L, 4L, 12L }, result.toArray());
    }

    @Test
    public void testBuildWithWholeNumber() {
        EgyptianFractions fractions = new EgyptianFractions();
        Long numerator = 7L;
        Long denominator = 1L;
        List<Long> result = fractions.build(numerator, denominator);
        // Verify that the result is [1, 1, 1, 1, 1, 1, 1]
        assertArrayEquals(new Long[] { 1L, 1L, 1L, 1L, 1L, 1L, 1L }, result.toArray());
    }
}
