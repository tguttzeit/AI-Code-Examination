package Copilot.EgyptianFractions.PromptOnly.T10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void testBuild() {
        assertEquals("1/2, 1/3, 1/13, 1/15", EgyptianFractions.build(2, 3));
    }

    @Test
    public void testBuild1() {
        assertEquals("1/3, 1/4, 1/12", EgyptianFractions.build(3, 4));
    }

    @Test
    public void testBuild2() {
        assertEquals("1/3, 1/11, 1/231", EgyptianFractions.build(3, 11));
    }
}
