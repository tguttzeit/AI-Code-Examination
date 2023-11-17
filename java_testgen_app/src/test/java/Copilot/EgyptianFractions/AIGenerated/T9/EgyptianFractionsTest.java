package Copilot.EgyptianFractions.AIGenerated.T9;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(13L, 21L);
        assertEquals(3, result.size());
        assertEquals(2L, result.get(0).longValue());
        assertEquals(7L, result.get(1).longValue());
        assertEquals(21L, result.get(2).longValue());
    }

    @Test
    public void test2() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(1L, 2L);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).longValue());
        assertEquals(2L, result.get(1).longValue());
    }

    @Test
    public void test3() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(12L, 13L);
        assertEquals(3, result.size());
        assertEquals(2L, result.get(0).longValue());
        assertEquals(3L, result.get(1).longValue());
        assertEquals(13L, result.get(2).longValue());
    }
}
