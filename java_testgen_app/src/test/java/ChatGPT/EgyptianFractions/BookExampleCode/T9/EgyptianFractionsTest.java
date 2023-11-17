package ChatGPT.EgyptianFractions.BookExampleCode.T9;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class EgyptianFractionsTest {

    @Test
    public void testCase1() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(3L, 7L);
        assertEquals("[3, 11, 231]", result.toString());
    }

    @Test
    public void testCase2() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(5L, 8L);
        assertEquals("[2, 8]", result.toString());
    }

    @Test
    public void testCase3() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(4L, 9L);
        assertEquals("[3, 6, 18]", result.toString());
    }
}
