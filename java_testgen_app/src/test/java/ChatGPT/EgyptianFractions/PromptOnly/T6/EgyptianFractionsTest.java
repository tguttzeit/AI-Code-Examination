package ChatGPT.EgyptianFractions.PromptOnly.T6;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;

public class EgyptianFractionsTest {

    private EgyptianFractions fractions;

    @Before
    public void setUp() {
        fractions = new EgyptianFractions();
    }

    @Test
    public void testBuildWithProperFraction() {
        List<Long> result = fractions.build(3L, 4L);
        List<Long> expected = Arrays.asList(2L, 4L);
        assertEquals(expected, result);
    }

    @Test
    public void testBuildWithUnitFraction() {
        List<Long> result = fractions.build(1L, 7L);
        List<Long> expected = Arrays.asList(7L);
        assertEquals(expected, result);
    }

    @Test
    public void testBuildWithImproperFraction() {
        List<Long> result = fractions.build(5L, 3L);
        List<Long> expected = Arrays.asList(2L, 3L, 3L);
        assertEquals(expected, result);
    }
}
