package Copilot.EgyptianFractions.AIGenerated.T1;

import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void testBuild() {
        EgyptianFractions fractions = new EgyptianFractions();
        assertThat(fractions.build(1L, 2L), is(Arrays.asList(2L)));
        assertThat(fractions.build(3L, 4L), is(Arrays.asList(2L, 4L)));
        assertThat(fractions.build(6L, 14L), is(Arrays.asList(3L, 11L, 231L)));
    }
}
