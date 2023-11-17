package ChatGPT.EgyptianFractions.AIGenerated.T3;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class EgyptianFractionsTest {

    @Test
    public void testSimpleFraction() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(3L, 4L);
        assertEquals(2, result.size());
        assertEquals(2L, (long) result.get(0));
        assertEquals(4L, (long) result.get(1));
    }

    @Test
    public void testLargeNumerator() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(5L, 12L);
        assertEquals(3, result.size());
        assertEquals(3L, (long) result.get(0));
        assertEquals(4L, (long) result.get(1));
        assertEquals(12L, (long) result.get(2));
    }

    @Test
    public void testLargeDenominator() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(7L, 30L);
        assertEquals(4, result.size());
        assertEquals(5L, (long) result.get(0));
        assertEquals(6L, (long) result.get(1));
        assertEquals(10L, (long) result.get(2));
        assertEquals(60L, (long) result.get(3));
    }
}
