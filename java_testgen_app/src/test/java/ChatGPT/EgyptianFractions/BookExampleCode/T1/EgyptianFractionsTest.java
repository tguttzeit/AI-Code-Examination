package ChatGPT.EgyptianFractions.BookExampleCode.T1;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class EgyptianFractionsTest {

    private EgyptianFractions egyptianFractions;

    @Before
    public void setUp() {
        egyptianFractions = new EgyptianFractions();
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
    public void testBuildWithValidFractions() {
        List<Long> result = egyptianFractions.build(2L, 5L);
        List<Long> expected = Arrays.asList(3L, 7L, 35L);
        assertEquals(expected, result);
    }
}
