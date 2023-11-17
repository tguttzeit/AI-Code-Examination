package ChatGPT.EgyptianFractions.BookExampleCode.T2;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class EgyptianFractionsTest {

    @Test
    public void testBuildWithZeroNumerator() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(0L, 7L);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testBuildWithZeroDenominator() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(3L, 0L);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testBuildWithProperFraction() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(2L, 5L);

        // Verify that 2/5 is represented as 1/3 + 1/15
        assertEquals(2, result.size());
        assertEquals(3L, (long) result.get(0));
        assertEquals(15L, (long) result.get(1));
    }

    @Test
    public void testBuildWithImproperFraction() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(7L, 3L);

        // Verify that 7/3 is represented as 2/1 + 1/2 + 1/6
        assertEquals(3, result.size());
        assertEquals(2L, (long) result.get(0));
        assertEquals(1L, (long) result.get(1));
        assertEquals(6L, (long) result.get(2));
    }
}
