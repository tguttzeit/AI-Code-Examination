package ChatGPT.EgyptianFractions.PromptOnly.T4;

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
    public void testBuildWithValidInput() {
        Long numerator = 3L;
        Long denominator = 7L;
        List<Long> result = egyptianFractions.build(numerator, denominator);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(1L, (long) result.get(0));
        assertEquals(2L, (long) result.get(1));
        assertEquals(7L, (long) result.get(2));
    }

    @Test
    public void testBuildWithZeroDenominator() {
        Long numerator = 5L;
        Long denominator = 0L;
        List<Long> result = egyptianFractions.build(numerator, denominator);
        assertNull(result);
    }

    @Test
    public void testBuildWithImproperFraction() {
        Long numerator = 8L;
        Long denominator = 5L;
        List<Long> result = egyptianFractions.build(numerator, denominator);
        assertNull(result);
    }
}
