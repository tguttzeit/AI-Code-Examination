package ChatGPT.EgyptianFractions.PromptOnly.T2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class EgyptianFractionsTest {
    private EgyptianFractions egyptianFractions;

    @Before
    public void setUp() {
        egyptianFractions = new EgyptianFractions();
    }

    @Test
    public void testBuildWithProperFraction() {
        Long numerator = 5L;
        Long denominator = 7L;
        List<Long> result = egyptianFractions.build(numerator, denominator);
        // You can check if the result is as expected here
        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).longValue());
        assertEquals(7L, result.get(1).longValue());
    }

    @Test
    public void testBuildWithImproperFraction() {
        Long numerator = 9L;
        Long denominator = 4L;
        List<Long> result = egyptianFractions.build(numerator, denominator);
        // You can check if the result is as expected here
        assertEquals(3, result.size());
        assertEquals(2L, result.get(0).longValue());
        assertEquals(2L, result.get(1).longValue());
        assertEquals(4L, result.get(2).longValue());
    }

    @Test
    public void testBuildWithZeroNumerator() {
        Long numerator = 0L;
        Long denominator = 8L;
        List<Long> result = egyptianFractions.build(numerator, denominator);
        // You can check if the result is as expected here
        assertEquals(0, result.size());
    }
}
