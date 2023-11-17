package Copilot.EgyptianFractions.PromptOnly.T7;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(4L, 13L);
        List<Long> expected = Arrays.asList(4L, 18L, 468L);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(3L, 7L);
        List<Long> expected = Arrays.asList(3L, 11L, 231L);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(5L, 121L);
        List<Long> expected = Arrays.asList(25L, 757L, 763309L);
        assertEquals(expected, result);
    }
}
