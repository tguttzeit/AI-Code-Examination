package Copilot.EgyptianFractions.PromptOnly.T5;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions test = new EgyptianFractions();
        List<Long> result = test.build(3L, 4L);
        List<Long> expected = new ArrayList<Long>();
        expected.add(2L);
        expected.add(4L);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {
        EgyptianFractions test = new EgyptianFractions();
        List<Long> result = test.build(6L, 14L);
        List<Long> expected = new ArrayList<Long>();
        expected.add(3L);
        expected.add(11L);
        expected.add(231L);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {
        EgyptianFractions test = new EgyptianFractions();
        List<Long> result = test.build(12L, 13L);
        List<Long> expected = new ArrayList<Long>();
        expected.add(2L);
        expected.add(4L);
        expected.add(156L);
        assertEquals(expected, result);
    }
}
