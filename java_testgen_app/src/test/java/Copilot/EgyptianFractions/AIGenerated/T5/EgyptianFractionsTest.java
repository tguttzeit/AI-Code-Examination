package Copilot.EgyptianFractions.AIGenerated.T5;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void testBuild() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(1L, 2L);
        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).longValue());
        assertEquals(2L, result.get(1).longValue());
    }

    @Test
    public void testBuild1() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(3L, 4L);
        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).longValue());
        assertEquals(4L, result.get(1).longValue());
    }

    @Test
    public void testBuild2() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(6L, 14L);
        assertEquals(3, result.size());
        assertEquals(3L, result.get(0).longValue());
        assertEquals(5L, result.get(1).longValue());
        assertEquals(30L, result.get(2).longValue());
    }
}
