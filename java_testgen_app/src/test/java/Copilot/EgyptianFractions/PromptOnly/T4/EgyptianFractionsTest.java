package Copilot.EgyptianFractions.PromptOnly.T4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void testBuild() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(6L, 14L);
        List<Long> expected = Arrays.asList(3L, 11L, 231L);
        assertEquals(expected, result);
    }

    @Test
    public void testBuild2() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(2L, 3L);
        List<Long> expected = Arrays.asList(2L, 6L);
        assertEquals(expected, result);
    }

    @Test
    public void testBuild3() {
        EgyptianFractions ef = new EgyptianFractions();
        List<Long> result = ef.build(1L, 2L);
        List<Long> expected = Arrays.asList(2L);
        assertEquals(expected, result);
    }
}
