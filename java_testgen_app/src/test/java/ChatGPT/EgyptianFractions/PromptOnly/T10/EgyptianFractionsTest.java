package ChatGPT.EgyptianFractions.PromptOnly.T10;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;

public class EgyptianFractionsTest {

    @Test
    public void testBuildWithValidInput() {
        EgyptianFractions fractions = new EgyptianFractions();
        List<Long> result = fractions.build(3L, 7L);

        List<Long> expected = Arrays.asList(1L, 2L, 7L);
        assertEquals(expected, result);
    }

    @Test
    public void testBuildWithIntegerInput() {
        EgyptianFractions fractions = new EgyptianFractions();
        List<Long> result = fractions.build(2L, 1L);

        List<Long> expected = Arrays.asList(2L);
        assertEquals(expected, result);
    }

    @Test
    public void testBuildWithZeroDenominator() {
        EgyptianFractions fractions = new EgyptianFractions();
        List<Long> result = fractions.build(5L, 0L);

        assertNull(result); // We expect null since division by zero is undefined.
    }
}
