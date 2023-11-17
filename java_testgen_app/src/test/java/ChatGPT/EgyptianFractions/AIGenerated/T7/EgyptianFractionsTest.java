package ChatGPT.EgyptianFractions.AIGenerated.T7;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EgyptianFractionsTest {

    @Test
    public void testSimpleFraction() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(3L, 4L);
        assertEquals("[2, 4]", result.toString());
    }

    @Test
    public void testProperFraction() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(5L, 7L);
        assertEquals("[2, 4, 28]", result.toString());
    }

    @Test
    public void testImproperFraction() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(8L, 5L);
        assertEquals("[2, 2, 2, 2, 2, 10]", result.toString());
    }
}
