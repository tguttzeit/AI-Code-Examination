package Copilot.EgyptianFractions.PromptOnly.T1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(3L, 7L);
        assertEquals(3, result.size());
        assertEquals(3, result.get(0).longValue());
        assertEquals(11, result.get(1).longValue());
        assertEquals(231, result.get(2).longValue());
    }

    @Test
    public void test2() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(2L, 3L);
        assertEquals(2, result.size());
        assertEquals(2, result.get(0).longValue());
        assertEquals(6, result.get(1).longValue());
    }

    @Test
    public void test3() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(5L, 8L);
        assertEquals(3, result.size());
        assertEquals(2, result.get(0).longValue());
        assertEquals(8, result.get(1).longValue());
        assertEquals(40, result.get(2).longValue());
    }
}
