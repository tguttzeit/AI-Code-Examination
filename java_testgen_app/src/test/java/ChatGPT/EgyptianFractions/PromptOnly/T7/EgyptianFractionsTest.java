package ChatGPT.EgyptianFractions.PromptOnly.T7;

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
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, (long) result.get(0));
        assertEquals(3L, (long) result.get(1));
    }

    @Test
    public void testBuildWithWholeNumber() {
        Long numerator = 7L;
        Long denominator = 1L;
        List<Long> result = egyptianFractions.build(numerator, denominator);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(7L, (long) result.get(0));
    }

    @Test
    public void testBuildWithImproperFraction() {
        Long numerator = 9L;
        Long denominator = 5L;
        List<Long> result = egyptianFractions.build(numerator, denominator);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(2L, (long) result.get(0));
        assertEquals(3L, (long) result.get(1));
    }
}
