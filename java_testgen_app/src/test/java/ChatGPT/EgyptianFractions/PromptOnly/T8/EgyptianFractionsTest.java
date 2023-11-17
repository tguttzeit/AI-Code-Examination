package ChatGPT.EgyptianFractions.PromptOnly.T8;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class EgyptianFractionsTest {

    private EgyptianFractions egyptianFractions;

    @Before
    public void setUp() {
        egyptianFractions = new EgyptianFractions();
    }

    @Test
    public void testBuildWithProperFraction() {
        Long numerator = 3L;
        Long denominator = 4L;

        List<Long> result = egyptianFractions.build(numerator, denominator);

        // Check if the sum of fractions equals the input
        Long sum = 0L;
        for (Long fraction : result) {
            sum += fraction;
        }
        assertEquals(numerator, sum);
        assertEquals(denominator, denominator(result));
    }

    @Test
    public void testBuildWithWholeNumber() {
        Long numerator = 5L;
        Long denominator = 1L;

        List<Long> result = egyptianFractions.build(numerator, denominator);

        // Check if the result contains only the numerator as a single fraction
        assertEquals(1, result.size());
        assertEquals(numerator, result.get(0));
        assertEquals(denominator, denominator(result));
    }

    @Test
    public void testBuildWithImproperFraction() {
        Long numerator = 7L;
        Long denominator = 4L;

        List<Long> result = egyptianFractions.build(numerator, denominator);

        // Check if the sum of fractions equals the input
        Long sum = 0L;
        for (Long fraction : result) {
            sum += fraction;
        }
        assertEquals(numerator, sum);
        assertEquals(denominator, denominator(result));
    }

    // Helper method to calculate the denominator of a list of fractions
    private Long denominator(List<Long> fractions) {
        long result = 1L;
        for (Long fraction : fractions) {
            result *= fraction;
        }
        return result;
    }
}
