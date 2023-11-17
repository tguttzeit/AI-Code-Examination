package Copilot.EgyptianFractions.PromptOnly.T8;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void testBuild() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result1 = egyptianFractions.build(2L, 3L);
        List<Long> result2 = egyptianFractions.build(6L, 14L);
        List<Long> result3 = egyptianFractions.build(12L, 13L);
        List<Long> expected1 = new ArrayList<>(Arrays.asList(2L, 6L));
        List<Long> expected2 = new ArrayList<>(Arrays.asList(1L, 3L, 11L, 231L));
        List<Long> expected3 = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 12L, 156L, 2028L));
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }
}
