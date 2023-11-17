package ChatGPT.EgyptianFractions.PromptOnly.T1;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class EgyptianFractionsTest {

    @Test
    public void testBuildWithValidInput() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(5L, 8L);
        assertEquals(3, result.size());
        assertEquals(2L, (long) result.get(0));
        assertEquals(8L, (long) result.get(1));
        assertEquals(8L, (long) result.get(2));
    }

    @Test
    public void testBuildWithUnitFraction() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(1L, 5L);
        assertEquals(5, result.size());
        for (long fraction : result) {
            assertEquals(5L, fraction);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithInvalidInput() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        egyptianFractions.build(2L, 1L); // Invalid input, numerator > denominator
    }
}
