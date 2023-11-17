package ChatGPT.EgyptianFractions.AIGenerated.T9;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class EgyptianFractionsTest {

    @Test
    public void testBuildWithSimpleFraction() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> fractions = egyptianFractions.build(3L, 7L);

        // The expected result for 3/7 is [3, 11, 231].
        assertEquals(3, fractions.size());
        assertEquals(3L, (long) fractions.get(0));
        assertEquals(11L, (long) fractions.get(1));
        assertEquals(231L, (long) fractions.get(2));
    }

    @Test
    public void testBuildWithUnitFraction() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> fractions = egyptianFractions.build(1L, 17L);

        // The expected result for 1/17 is [17].
        assertEquals(1, fractions.size());
        assertEquals(17L, (long) fractions.get(0));
    }

    @Test
    public void testBuildWithLargeDenominator() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> fractions = egyptianFractions.build(5L, 1000L);

        // The expected result for 5/1000 is [200, 800].
        assertEquals(2, fractions.size());
        assertEquals(200L, (long) fractions.get(0));
        assertEquals(800L, (long) fractions.get(1));
    }
}
