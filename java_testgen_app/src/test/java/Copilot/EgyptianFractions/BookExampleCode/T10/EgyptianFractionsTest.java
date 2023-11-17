package Copilot.EgyptianFractions.BookExampleCode.T10;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> l = ef.build(6L, 14L);
        assertEquals(3, l.size());
        assertEquals(3L, l.get(0).longValue());
        assertEquals(11L, l.get(1).longValue());
        assertEquals(231L, l.get(2).longValue());
    }

    @Test
    public void test2() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> l = ef.build(2L, 3L);
        assertEquals(2, l.size());
        assertEquals(2L, l.get(0).longValue());
        assertEquals(6L, l.get(1).longValue());
    }

    @Test
    public void test3() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> l = ef.build(6L, 3L);
        assertEquals(1, l.size());
        assertEquals(2L, l.get(0).longValue());
    }
}
