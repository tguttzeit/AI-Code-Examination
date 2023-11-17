package Copilot.EgyptianFractions.BookExampleCode.T6;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> r = e.build(43L, 48L);
        assertEquals(4, r.size());
        assertEquals(2L, r.get(0).longValue());
        assertEquals(4L, r.get(1).longValue());
        assertEquals(12L, r.get(2).longValue());
        assertEquals(288L, r.get(3).longValue());
    }

    @Test
    public void test2() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> r = e.build(3L, 7L);
        assertEquals(3, r.size());
        assertEquals(3L, r.get(0).longValue());
        assertEquals(11L, r.get(1).longValue());
        assertEquals(231L, r.get(2).longValue());
    }

    @Test
    public void test3() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> r = e.build(7L, 3L);
        assertEquals(3, r.size());
        assertEquals(3L, r.get(0).longValue());
        assertEquals(2L, r.get(1).longValue());
        assertEquals(42L, r.get(2).longValue());
    }
}
