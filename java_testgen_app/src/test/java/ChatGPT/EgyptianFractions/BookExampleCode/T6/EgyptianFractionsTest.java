package ChatGPT.EgyptianFractions.BookExampleCode.T6;

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
    public void testEgyptianFractionForOneHalf() {
        List<Long> result = egyptianFractions.build(1L, 2L);
        assertEquals(2, result.size());
        assertEquals(1L, (long) result.get(0));
        assertEquals(2L, (long) result.get(1));
    }

    @Test
    public void testEgyptianFractionForThreeSevenths() {
        List<Long> result = egyptianFractions.build(3L, 7L);
        assertEquals(3, result.size());
        assertEquals(3L, (long) result.get(0));
        assertEquals(11L, (long) result.get(1));
        assertEquals(231L, (long) result.get(2));
    }

    @Test
    public void testEgyptianFractionForFiveElevenths() {
        List<Long> result = egyptianFractions.build(5L, 11L);
        assertEquals(3, result.size());
        assertEquals(3L, (long) result.get(0));
        assertEquals(4L, (long) result.get(1));
        assertEquals(44L, (long) result.get(2));
    }
}
