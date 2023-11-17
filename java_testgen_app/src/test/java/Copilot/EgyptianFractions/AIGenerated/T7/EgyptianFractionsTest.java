package Copilot.EgyptianFractions.AIGenerated.T7;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(4L, 13L);
        assertEquals(4, result.size());
        assertEquals(4, result.get(0).longValue());
        assertEquals(18, result.get(1).longValue());
        assertEquals(468, result.get(2).longValue());
        assertEquals(936, result.get(3).longValue());
    }

    @Test
    public void test2() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(3L, 7L);
        assertEquals(2, result.size());
        assertEquals(3, result.get(0).longValue());
        assertEquals(11, result.get(1).longValue());
    }

    @Test
    public void test3() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(2L, 3L);
        assertEquals(2, result.size());
        assertEquals(2, result.get(0).longValue());
        assertEquals(6, result.get(1).longValue());
    }
}
