package ChatGPT.EgyptianFractions.AIGenerated.T10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class EgyptianFractionsTest {
    private EgyptianFractions egyptianFractions;

    @Before
    public void setUp() {
        egyptianFractions = new EgyptianFractions();
    }

    @Test
    public void testValidFraction() {
        List<Long> expectedFractions = Arrays.asList(3L, 7L, 11L, 2310L);
        List<Long> actualFractions = egyptianFractions.build(3L, 7L);
        assertEquals(expectedFractions, actualFractions);
        assertTrue(isValidEgyptianFraction(3L, 7L, actualFractions));
    }

    @Test
    public void testWholeNumber() {
        List<Long> expectedFractions = Arrays.asList(2L);
        List<Long> actualFractions = egyptianFractions.build(2L, 1L);
        assertEquals(expectedFractions, actualFractions);
        assertTrue(isValidEgyptianFraction(2L, 1L, actualFractions));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput() {
        egyptianFractions.build(-5L, 10L);
    }

    // Helper method to check if the fractions sum up to the original number.
    private boolean isValidEgyptianFraction(Long numerator, Long denominator, List<Long> fractions) {
        long sum = 0;
        for (Long fraction : fractions) {
            sum += (numerator * fraction);
        }
        return sum == denominator;
    }
}
