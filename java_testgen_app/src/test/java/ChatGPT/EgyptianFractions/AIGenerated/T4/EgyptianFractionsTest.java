package ChatGPT.EgyptianFractions.AIGenerated.T4;

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
    public void testEgyptianFraction1() {
        List<Long> fractions = egyptianFractions.build(4L, 7L);
        assertEquals(3, fractions.size());
        assertEquals(2L, (long) fractions.get(0));
        assertEquals(4L, (long) fractions.get(1));
        assertEquals(28L, (long) fractions.get(2));
    }

    @Test
    public void testEgyptianFraction2() {
        List<Long> fractions = egyptianFractions.build(5L, 8L);
        assertEquals(2, fractions.size());
        assertEquals(2L, (long) fractions.get(0));
        assertEquals(8L, (long) fractions.get(1));
    }

    @Test
    public void testEgyptianFraction3() {
        List<Long> fractions = egyptianFractions.build(1L, 3L);
        assertEquals(3, fractions.size());
        assertEquals(2L, (long) fractions.get(0));
        assertEquals(6L, (long) fractions.get(1));
        assertEquals(18L, (long) fractions.get(2));
    }
}
