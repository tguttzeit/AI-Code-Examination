package Copilot.EgyptianFractions.BookExampleCode.T2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class EgyptianFractionsTest {
    @Test
    public void test0() {
        EgyptianFractions e = new EgyptianFractions();
        assertEquals(new ArrayList<>(), e.build(0L, 0L));
    }

    @Test
    public void test1() {
        EgyptianFractions e = new EgyptianFractions();
        assertEquals(new ArrayList<>(), e.build(0L, 1L));
    }

    @Test
    public void test2() {
        EgyptianFractions e = new EgyptianFractions();
        assertEquals(new ArrayList<>(), e.build(1L, 0L));
    }

    @Test
    public void test3() {
        EgyptianFractions e = new EgyptianFractions();
        assertEquals(Arrays.asList(2L), e.build(1L, 2L));
    }

    @Test
    public void test4() {
        EgyptianFractions e = new EgyptianFractions();
        assertEquals(Arrays.asList(2L, 3L, 13L, 360L, 365L, 366L), e.build(1L, 2L));
    }

    @Test
    public void test5() {
        EgyptianFractions e = new EgyptianFractions();
        assertEquals(Arrays.asList(2L, 3L, 13L, 360L, 365L, 366L), e.build(1L, 2L));
    }

    @Test
    public void test6() {
        EgyptianFractions e = new EgyptianFractions();
        assertEquals(Arrays.asList(2L, 3L, 13L, 360L, 365L, 366L), e.build(1L, 2L));
    }

    @Test
    public void test7() {
        EgyptianFractions e = new EgyptianFractions();
        assertEquals(Arrays.asList(2L, 3L, 13L, 360L, 365L, 366L), e.build(1L, 2L));
    }
}
