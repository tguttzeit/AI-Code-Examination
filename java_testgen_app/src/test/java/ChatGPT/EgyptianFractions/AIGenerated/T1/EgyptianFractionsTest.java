package ChatGPT.EgyptianFractions.AIGenerated.T1;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class EgyptianFractionsTest {

    @Test
    public void testEgyptianFractions1() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(3L, 7L);

        // The Egyptian fractions representation of 3/7 is [1, 2, 7]
        assertArrayEquals(new Long[] { 1L, 2L, 7L }, result.toArray());
    }

    @Test
    public void testEgyptianFractions2() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(5L, 8L);

        // The Egyptian fractions representation of 5/8 is [2, 8]
        assertArrayEquals(new Long[] { 2L, 8L }, result.toArray());
    }

    @Test
    public void testEgyptianFractions3() {
        EgyptianFractions egyptianFractions = new EgyptianFractions();
        List<Long> result = egyptianFractions.build(2L, 3L);

        // The Egyptian fractions representation of 2/3 is [2, 6]
        assertArrayEquals(new Long[] { 2L, 6L }, result.toArray());
    }
}
