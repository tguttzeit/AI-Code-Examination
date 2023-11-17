package ChatGPT.EgyptianFractions.AIGenerated.T2;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EgyptianFractionsTest {
    private EgyptianFractions egyptianFractions;

    @Before
    public void setUp() {
        egyptianFractions = new EgyptianFractions();
    }

    @Test
    public void testEgyptianFraction1() {
        List<Long> fractions = egyptianFractions.build(5L, 7L);
        assertEquals(3, fractions.size());
        assertEquals(2L, fractions.get(0).longValue());
        assertEquals(4L, fractions.get(1).longValue());
        assertEquals(28L, fractions.get(2).longValue());
    }

    @Test
    public void testEgyptianFraction2() {
        List<Long> fractions = egyptianFractions.build(3L, 11L);
        assertEquals(4, fractions.size());
        assertEquals(4L, fractions.get(0).longValue());
        assertEquals(14L, fractions.get(1).longValue());
        assertEquals(154L, fractions.get(2).longValue());
        assertEquals(429L, fractions.get(3).longValue());
    }

    @Test
    public void testEgyptianFraction3() {
        List<Long> fractions = egyptianFractions.build(7L, 8L);
        assertEquals(3, fractions.size());
        assertEquals(2L, fractions.get(0).longValue());
        assertEquals(8L, fractions.get(1).longValue());
        assertEquals(64L, fractions.get(2).longValue());
    }
}
