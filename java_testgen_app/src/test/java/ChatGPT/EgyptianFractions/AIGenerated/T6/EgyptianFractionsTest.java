package ChatGPT.EgyptianFractions.AIGenerated.T6;

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
        List<Long> result = egyptianFractions.build(5L, 7L);
        assertEquals(2, result.size());
        assertEquals(2L, (long) result.get(0));
        assertEquals(7L, (long) result.get(1));
    }

    @Test
    public void testEgyptianFraction2() {
        List<Long> result = egyptianFractions.build(3L, 4L);
        assertEquals(2, result.size());
        assertEquals(2L, (long) result.get(0));
        assertEquals(4L, (long) result.get(1));
    }

    @Test
    public void testEgyptianFraction3() {
        List<Long> result = egyptianFractions.build(8L, 11L);
        assertEquals(3, result.size());
        assertEquals(2L, (long) result.get(0));
        assertEquals(5L, (long) result.get(1));
        assertEquals(22L, (long) result.get(2));
    }
}
