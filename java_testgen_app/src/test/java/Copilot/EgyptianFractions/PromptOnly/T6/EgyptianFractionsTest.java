package Copilot.EgyptianFractions.PromptOnly.T6;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test1() {
        EgyptianFractions test1 = new EgyptianFractions();
        test1.build(2L, 3L);
        test1.build(6L, 14L);
        test1.build(12L, 13L);
    }
}
