package Copilot.EgyptianFractions.BookExampleCode.T7;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> r = ef.build(2L, 3L);
        assertEquals(2, r.get(0).longValue());
        assertEquals(6, r.get(1).longValue());
    }

    @Test
    public void test2() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> r = ef.build(6L, 14L);
        assertEquals(3, r.get(0).longValue());
        assertEquals(11, r.get(1).longValue());
        assertEquals(231, r.get(2).longValue());
    }

    @Test
    public void test3() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> r = ef.build(2L, 1L);
        assertEquals(2, r.get(0).longValue());
    }
}
