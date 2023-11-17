package Copilot.EgyptianFractions.BookExampleCode.T5;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> l = e.build(6L, 14L);
        assertEquals(3, l.size());
        assertEquals(3L, l.get(0).longValue());
        assertEquals(11L, l.get(1).longValue());
        assertEquals(231L, l.get(2).longValue());
    }

    @Test
    public void test2() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> l = e.build(2L, 3L);
        assertEquals(2, l.size());
        assertEquals(2L, l.get(0).longValue());
        assertEquals(6L, l.get(1).longValue());
    }

    @Test
    public void test3() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> l = e.build(3L, 7L);
        assertEquals(3, l.size());
        assertEquals(3L, l.get(0).longValue());
        assertEquals(11L, l.get(1).longValue());
        assertEquals(231L, l.get(2).longValue());
    }
}
