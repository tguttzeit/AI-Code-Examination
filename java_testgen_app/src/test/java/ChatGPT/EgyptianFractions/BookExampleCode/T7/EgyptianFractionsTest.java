package ChatGPT.EgyptianFractions.BookExampleCode.T7;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Arrays;

public class EgyptianFractionsTest {

    private EgyptianFractions egyptianFractions;

    @Before
    public void setUp() {
        egyptianFractions = new EgyptianFractions();
    }

    @After
    public void tearDown() {
        egyptianFractions = null;
    }

    @Test
    public void testBuildWithZeroNumerator() {
        List<Long> result = egyptianFractions.build(0L, 5L);
        List<Long> expected = Arrays.asList();
        assertEquals(expected, result);
    }

    @Test
    public void testBuildWithZeroDenominator() {
        List<Long> result = egyptianFractions.build(3L, 0L);
        List<Long> expected = Arrays.asList();
        assertEquals(expected, result);
    }

    @Test
    public void testBuildWithProperFraction() {
        List<Long> result = egyptianFractions.build(3L, 7L);
        List<Long> expected = Arrays.asList(3L, 11L, 231L);
        assertEquals(expected, result);
    }

    @Test
    public void testBuildWithImproperFraction() {
        List<Long> result = egyptianFractions.build(5L, 2L);
        List<Long> expected = Arrays.asList(3L, 4L);
        assertEquals(expected, result);
    }
}
