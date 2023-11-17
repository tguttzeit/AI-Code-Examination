package ChatGPT.EgyptianFractions.AIGenerated.T5;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EgyptianFractionsTest {

    private EgyptianFractions egyptianFractions;

    @Before
    public void setUp() {
        egyptianFractions = new EgyptianFractions();
    }

    @Test
    public void testEgyptianFractionsCase1() {
        List<Long> fractions = egyptianFractions.build(5L, 7L);
        // Expected result: [2, 3, 42]
        assertEquals("[2, 3, 42]", fractions.toString());
    }

    @Test
    public void testEgyptianFractionsCase2() {
        List<Long> fractions = egyptianFractions.build(3L, 4L);
        // Expected result: [2, 4]
        assertEquals("[2, 4]", fractions.toString());
    }

    @Test
    public void testEgyptianFractionsCase3() {
        List<Long> fractions = egyptianFractions.build(7L, 8L);
        // Expected result: [2, 4, 8]
        assertEquals("[2, 4, 8]", fractions.toString());
    }
}
