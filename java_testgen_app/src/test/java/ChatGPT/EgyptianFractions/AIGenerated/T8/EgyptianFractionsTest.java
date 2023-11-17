package ChatGPT.EgyptianFractions.AIGenerated.T8;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EgyptianFractionsTest {

    private EgyptianFractions egyptianFractions;

    @Before
    public void setUp() {
        egyptianFractions = new EgyptianFractions();
    }

    @Test
    public void testSimpleFraction() {
        List<Long> result = egyptianFractions.build(3L, 7L);
        assertEquals(3, result.size());
        assertTrue(result.contains(3L));
        assertTrue(result.contains(11L));
        assertTrue(result.contains(231L));
    }

    @Test
    public void testUnitFraction() {
        List<Long> result = egyptianFractions.build(1L, 5L);
        assertEquals(5, result.size());
        assertTrue(result.contains(1L));
        assertTrue(result.contains(2L));
        assertTrue(result.contains(3L));
        assertTrue(result.contains(4L));
        assertTrue(result.contains(20L));
    }

    @Test
    public void testSameFraction() {
        List<Long> result = egyptianFractions.build(4L, 4L);
        assertEquals(1, result.size());
        assertTrue(result.contains(1L));
    }
}
