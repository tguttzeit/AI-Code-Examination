package ChatGPT.EgyptianFractions.BookExampleCode.T8;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

public class EgyptianFractionsTest {

    @Test
    public void testSimpleFraction() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(3L, 4L);
        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).longValue());
        assertEquals(4L, result.get(1).longValue());
    }

    @Test
    public void testFractionWithLargeDenominator() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(1L, 100L);
        assertEquals(99, result.size());
        // Verify that the sum of fractions equals 1
        long sum = result.stream().mapToLong(Long::longValue).sum();
        assertEquals(1L, sum);
    }

    @Test
    public void testZeroNumerator() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(0L, 7L);
        assertEquals(0, result.size());
    }
}
