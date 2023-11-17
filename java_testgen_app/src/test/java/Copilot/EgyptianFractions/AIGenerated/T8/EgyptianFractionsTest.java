package Copilot.EgyptianFractions.AIGenerated.T8;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    private EgyptianFractions egyptianFractions = new EgyptianFractions();

    @Test(expected = IllegalArgumentException.class)
    public void testNumeratorIsZero() {
        egyptianFractions.build(0L, 10L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDenominatorIsZero() {
        egyptianFractions.build(10L, 0L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumeratorIsNegative() {
        egyptianFractions.build(-1L, 10L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDenominatorIsNegative() {
        egyptianFractions.build(10L, -1L);
    }

    @Test
    public void testNumeratorIsSmallerThanDenominator() {
        List<Long> result = egyptianFractions.build(1L, 2L);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).longValue());
        assertEquals(2L, result.get(1).longValue());
    }

    @Test
    public void testNumeratorIsLargerThanDenominator() {
        List<Long> result = egyptianFractions.build(6L, 14L);
        assertEquals(3, result.size());
        assertEquals(1L, result.get(0).longValue());
        assertEquals(3L, result.get(1).longValue());
        assertEquals(11L, result.get(2).longValue());
    }

    @Test
    public void testNumeratorIsEqualToDenominator() {
        List<Long> result = egyptianFractions.build(1L, 1L);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).longValue());
    }
}
