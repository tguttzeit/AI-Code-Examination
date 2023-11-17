package Copilot.EgyptianFractions.AIGenerated.T6;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(5L, 121L);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(25L, result.get(0).longValue());
        Assert.assertEquals(757L, result.get(1).longValue());
        Assert.assertEquals(763309L, result.get(2).longValue());
    }
}
