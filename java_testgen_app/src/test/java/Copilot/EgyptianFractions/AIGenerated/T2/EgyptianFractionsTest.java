package Copilot.EgyptianFractions.AIGenerated.T2;

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
        List<Long> result = egyptianFractions.build(4L, 13L);
        assertEquals(4, result.size());
        assertEquals(4, result.get(0).longValue());
        assertEquals(4, result.get(1).longValue());
        assertEquals(4, result.get(2).longValue());
        assertEquals(13, result.get(3).longValue());
    }

    @Test
    public void test2() {
        List<Long> result = egyptianFractions.build(5L, 121L);
        assertEquals(3, result.size());
        assertEquals(25, result.get(0).longValue());
        assertEquals(757, result.get(1).longValue());
        assertEquals(763309, result.get(2).longValue());
    }

    @Test
    public void test3() {
        List<Long> result = egyptianFractions.build(2L, 3L);
        assertEquals(2, result.size());
        assertEquals(2, result.get(0).longValue());
        assertEquals(3, result.get(1).longValue());
    }
}
