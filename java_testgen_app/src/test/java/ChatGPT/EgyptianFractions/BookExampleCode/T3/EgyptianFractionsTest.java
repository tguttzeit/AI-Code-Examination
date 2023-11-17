package ChatGPT.EgyptianFractions.BookExampleCode.T3;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

public class EgyptianFractionsTest {
    private EgyptianFractions egyptianFractions;

    @Before
    public void setUp() {
        egyptianFractions = new EgyptianFractions();
    }

    @Test
    public void testFraction1() {
        List<Long> result = egyptianFractions.build(3L, 7L);
        assertEquals(2, result.size());
        assertEquals(3L, (long) result.get(0));
        assertEquals(11L, (long) result.get(1));
    }

    @Test
    public void testFraction2() {
        List<Long> result = egyptianFractions.build(5L, 8L);
        assertEquals(2, result.size());
        assertEquals(2L, (long) result.get(0));
        assertEquals(8L, (long) result.get(1));
    }

    @Test
    public void testFraction3() {
        List<Long> result = egyptianFractions.build(1L, 2L);
        assertEquals(2, result.size());
        assertEquals(1L, (long) result.get(0));
        assertEquals(2L, (long) result.get(1));
    }
}
