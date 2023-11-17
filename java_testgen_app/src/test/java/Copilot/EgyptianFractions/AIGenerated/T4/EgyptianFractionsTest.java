package Copilot.EgyptianFractions.AIGenerated.T4;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(5L, 7L);
        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).longValue());
        assertEquals(4L, result.get(1).longValue());
    }

    @Test
    public void test2() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(4L, 13L);
        assertEquals(3, result.size());
        assertEquals(4L, result.get(0).longValue());
        assertEquals(18L, result.get(1).longValue());
        assertEquals(468L, result.get(2).longValue());
    }

    @Test
    public void test3() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(1L, 3L);
        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).longValue());
        assertEquals(6L, result.get(1).longValue());
    }
}
