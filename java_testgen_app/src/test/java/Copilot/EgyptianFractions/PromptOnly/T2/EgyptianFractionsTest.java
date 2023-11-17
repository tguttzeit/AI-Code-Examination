package Copilot.EgyptianFractions.PromptOnly.T2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> actual = egyptianFractions.build(3L, 7L);
        List<Long> expected = Arrays.asList(2L, 5L, 70L);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> actual = egyptianFractions.build(5L, 121L);
        List<Long> expected = Arrays.asList(25L, 757L, 763309L, 873960180913L);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> actual = egyptianFractions.build(7L, 11L);
        List<Long> expected = Arrays.asList(2L, 79L, 858L, 17214L);
        assertEquals(expected, actual);
    }
}
