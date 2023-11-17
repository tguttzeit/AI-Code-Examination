package ChatGPT.EgyptianFractions.BookExampleCode.T5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void testBasicCase() {
        List<Long> result = egyptianFractions.build(3L, 7L);
        assertEquals(2, result.size());
        assertEquals(3L, result.get(0).longValue());
        assertEquals(11L, result.get(1).longValue());
    }

    @Test
    public void testFractionWithSameNumeratorAndDenominator() {
        List<Long> result = egyptianFractions.build(5L, 5L);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).longValue());
    }

    @Test
    public void testZeroNumeratorOrDenominator() {
        List<Long> result1 = egyptianFractions.build(0L, 7L);
        List<Long> result2 = egyptianFractions.build(3L, 0L);

        assertTrue(result1.isEmpty());
        assertTrue(result2.isEmpty());
    }
}
