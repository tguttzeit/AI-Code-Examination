package Copilot.EgyptianFractions.PromptOnly.T10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void testBuild() {
        assertEquals("1/2, 1/3, 1/13, 1/15", new EgyptianFractions().build(2L, 3L));
    }

    @Test
    public void testBuild1() {
        assertEquals("1/3, 1/4, 1/12", new EgyptianFractions().build(3L, 4L));
    }

    @Test
    public void testBuild2() {
        assertEquals("1/3, 1/11, 1/231", new EgyptianFractions().build(3L, 11L));
    }
}
