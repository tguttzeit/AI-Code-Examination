package Copilot.EgyptianFractions.PromptOnly.T9;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void testBuild() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(3L, 7L);
        assertEquals(2, result.size());
        assertEquals(3L, result.get(0).longValue());
        assertEquals(11L, result.get(1).longValue());
    }

    @Test
    public void testBuild2() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(2L, 3L);
        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).longValue());
        assertEquals(6L, result.get(1).longValue());
    }

    @Test
    public void testBuild3() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(4L, 13L);
        assertEquals(3, result.size());
        assertEquals(4L, result.get(0).longValue());
        assertEquals(18L, result.get(1).longValue());
        assertEquals(468L, result.get(2).longValue());
    }
}
