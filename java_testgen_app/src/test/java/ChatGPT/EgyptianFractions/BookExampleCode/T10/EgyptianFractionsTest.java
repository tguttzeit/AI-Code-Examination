package ChatGPT.EgyptianFractions.BookExampleCode.T10;

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
    public void testBuildEgyptianFraction_simpleCase() {
        List<Long> result = egyptianFractions.build(3L, 7L);
        assertEquals(2, result.size());
        assertEquals(Long.valueOf(3), result.get(0));
        assertEquals(Long.valueOf(11), result.get(1));
    }

    @Test
    public void testBuildEgyptianFraction_unitFraction() {
        List<Long> result = egyptianFractions.build(1L, 5L);
        assertEquals(5, result.size());
        assertEquals(Long.valueOf(1), result.get(0));
        assertEquals(Long.valueOf(2), result.get(1));
        assertEquals(Long.valueOf(3), result.get(2));
        assertEquals(Long.valueOf(4), result.get(3));
        assertEquals(Long.valueOf(5), result.get(4));
    }

    @Test
    public void testBuildEgyptianFraction_improperFraction() {
        List<Long> result = egyptianFractions.build(4L, 3L);
        assertEquals(2, result.size());
        assertEquals(Long.valueOf(2), result.get(0));
        assertEquals(Long.valueOf(3), result.get(1));
    }
}
