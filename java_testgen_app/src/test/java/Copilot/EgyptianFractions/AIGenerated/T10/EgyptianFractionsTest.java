package Copilot.EgyptianFractions.AIGenerated.T10;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class EgyptianFractionsTest {
    private EgyptianFractions egyptianFractions;

    @Before
    public void setUp() {
        egyptianFractions = new EgyptianFractions();
    }

    @Test
    public void test1() {
        List<Long> result = egyptianFractions.build(2L, 3L);
        assertEquals(2, result.size());
        assertEquals(2L, (long) result.get(0));
        assertEquals(6L, (long) result.get(1));
    }

    @Test
    public void test2() {
        List<Long> result = egyptianFractions.build(3L, 7L);
        assertEquals(3, result.size());
        assertEquals(2L, (long) result.get(0));
        assertEquals(4L, (long) result.get(1));
        assertEquals(28L, (long) result.get(2));
    }

    @Test
    public void test3() {
        List<Long> result = egyptianFractions.build(5L, 121L);
        assertEquals(3, result.size());
        assertEquals(25L, (long) result.get(0));
        assertEquals(757L, (long) result.get(1));
        assertEquals(763309L, (long) result.get(2));
    }
}
