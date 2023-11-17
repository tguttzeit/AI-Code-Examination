package Copilot.EgyptianFractions.BookExampleCode.T9;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class EgyptianFractionsTest {
    private EgyptianFractions egyptianFractions = new EgyptianFractions();

    @Test
    public void test() {
        assertEquals(Arrays.asList(2L, 6L), egyptianFractions.build(1L, 3L));
        assertEquals(Arrays.asList(1L, 2L, 6L), egyptianFractions.build(1L, 7L));
        assertEquals(Arrays.asList(1L, 2L, 3L, 13L, 360L), egyptianFractions.build(1L, 361L));
    }
}
