package ChatGPT.EgyptianFractions.PromptOnly.T9;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class EgyptianFractionsTest {

    @Test
    public void testBuildWithValidInput() {
        EgyptianFractions fractions = new EgyptianFractions();
        List<Long> result = fractions.build(4L, 7L);
        assertEquals(3, result.size());
        assertEquals(2L, result.get(0).longValue());
        assertEquals(7L, result.get(1).longValue());
        assertEquals(28L, result.get(2).longValue());
    }

    @Test
    public void testBuildWithWholeNumberInput() {
        EgyptianFractions fractions = new EgyptianFractions();
        List<Long> result = fractions.build(2L, 1L); // 2/1 is a whole number
        assertEquals(1, result.size());
        assertEquals(2L, result.get(0).longValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithInvalidInput() {
        EgyptianFractions fractions = new EgyptianFractions();
        fractions.build(0L, 5L); // Denominator should not be zero
    }
}
