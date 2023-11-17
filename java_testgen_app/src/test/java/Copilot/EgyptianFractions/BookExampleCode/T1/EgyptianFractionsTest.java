package Copilot.EgyptianFractions.BookExampleCode.T1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        List<Long> r = new EgyptianFractions().build(3L, 7L);
        assertEquals(r.size(), 3);
        assertEquals(r.get(0).longValue(), 3);
        assertEquals(r.get(1).longValue(), 11);
        assertEquals(r.get(2).longValue(), 231);
    }

    @Test
    public void test2() {
        List<Long> r = new EgyptianFractions().build(2L, 5L);
        assertEquals(r.size(), 2);
        assertEquals(r.get(0).longValue(), 3);
        assertEquals(r.get(1).longValue(), 15);
    }

    @Test
    public void test3() {
        List<Long> r = new EgyptianFractions().build(6L, 14L);
        assertEquals(r.size(), 3);
        assertEquals(r.get(0).longValue(), 3);
        assertEquals(r.get(1).longValue(), 7);
        assertEquals(r.get(2).longValue(), 42);
    }
}
