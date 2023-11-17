package ChatGPT.EgyptianFractions.PromptOnly.T3;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class EgyptianFractionsTest {

    private static EgyptianFractions egyptianFractions;

    @BeforeClass
    public static void setUp() {
        egyptianFractions = new EgyptianFractions();
    }

    @Test
    public void testBuildWithProperFraction() {
        Long numerator = 3L;
        Long denominator = 4L;

        List<Long> result = egyptianFractions.build(numerator, denominator);

        // Expected result for 3/4 is [1, 2, 4]
        assertArrayEquals(new Long[] { 1L, 2L, 4L }, result.toArray());
    }

    @Test
    public void testBuildWithImproperFraction() {
        Long numerator = 7L;
        Long denominator = 3L;

        List<Long> result = egyptianFractions.build(numerator, denominator);

        // Expected result for 7/3 is [3, 11]
        assertArrayEquals(new Long[] { 3L, 11L }, result.toArray());
    }

    @Test
    public void testBuildWithOne() {
        Long numerator = 1L;
        Long denominator = 1L;

        List<Long> result = egyptianFractions.build(numerator, denominator);

        // Expected result for 1/1 is [1]
        assertArrayEquals(new Long[] { 1L }, result.toArray());
    }
}
