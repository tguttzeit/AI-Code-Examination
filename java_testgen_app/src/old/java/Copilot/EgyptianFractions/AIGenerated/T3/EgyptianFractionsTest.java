package Copilot.EgyptianFractions.AIGenerated.T3;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class EgyptianFractionsTest {
    private EgyptianFractions egyptianFractions;

    @Before
    public void setUp() {
        egyptianFractions = new EgyptianFractions();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumeratorIsNotPositive() {
        egyptianFractions.build(-1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDenominatorIsNotPositive() {
        egyptianFractions.build(1, -2);
    }

    @Test
    public void testNumeratorIsZero() {
        List<Long> result = egyptianFractions.build(0, 2);
        assertEquals(0, result.size());
    }

    @Test
    public void testDenominatorIsZero() {
        List<Long> result = egyptianFractions.build(1, 0);
        assertEquals(0, result.size());
    }

    @Test
    public void testNumeratorIsLessThanDenominator() {
        List<Long> result = egyptianFractions.build(1, 2);
        assertEquals(1, result.size());
        assertEquals(2, result.get(0).longValue());
    }

    @Test
    public void testNumeratorIsGreaterThanDenominator() {
        List<Long> result = egyptianFractions.build(7, 3);
        assertEquals(2, result.size());
        assertEquals(3, result.get(0).longValue());
        assertEquals(2, result.get(1).longValue());
    }

    @Test
    public void testNumeratorIsEqualsToDenominator() {
        List<Long> result = egyptianFractions.build(3, 3);
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).longValue());
    }

    @Test
    public void testNumeratorIsOne() {
        List<Long> result = egyptianFractions.build(1, 2);
        assertEquals(1, result.size());
        assertEquals(2, result.get(0).longValue());
    }

    @Test
    public void testDenominatorIsOne() {
        List<Long> result = egyptianFractions.build(3, 1);
        assertEquals(1, result.size());
        assertEquals(3, result.get(0).longValue());
    }

    @Test
    public void testNumeratorAndDenominatorHaveCommonFactor
}
