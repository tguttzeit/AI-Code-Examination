package Copilot.EgyptianFractions.BookExampleCode.T8;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> l = e.build(1L, 2L);
        assertEquals(2, l.size());
        assertEquals(2L, l.get(0).longValue());
        assertEquals(2L, l.get(1).longValue());
    }

    @Test
    public void test2() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> l = e.build(1L, 3L);
        assertEquals(2, l.size());
        assertEquals(2L, l.get(0).longValue());
        assertEquals(6L, l.get(1).longValue());
    }

    @Test
    public void test3() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> l = e.build(1L, 4L);
        assertEquals(2, l.size());
        assertEquals(4L, l.get(0).longValue());
        assertEquals(4L, l.get(1).longValue());
    }
}
