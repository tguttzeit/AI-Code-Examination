package Copilot.EgyptianFractions.PromptOnly.T3;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> l = e.build(2, 3);
        assertEquals(l.size(), 2);
        assertEquals((long) l.get(0), 2);
        assertEquals((long) l.get(1), 6);
    }

    @Test
    public void test2() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> l = e.build(6, 14);
        assertEquals(l.size(), 3);
        assertEquals((long) l.get(0), 1);
        assertEquals((long) l.get(1), 3);
        assertEquals((long) l.get(2), 42);
    }

    @Test
    public void test3() {
        EgyptianFractions e = new EgyptianFractions();
        List<Long> l = e.build(3, 8);
        assertEquals(l.size(), 3);
        assertEquals((long) l.get(0), 1);
        assertEquals((long) l.get(1), 3);
        assertEquals((long) l.get(2), 24);
    }
}
