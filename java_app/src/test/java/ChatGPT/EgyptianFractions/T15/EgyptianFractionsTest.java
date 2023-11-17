package ChatGPT.EgyptianFractions.T15;

// Source: https://github.com/TrainingByPackt/Data-Structures-and-Algorithms-in-Java/blob/master/src/test/java/com/packt/datastructuresandalg/lesson4/activity/egyptian/EgyptianFractionsTest.java

import junit.framework.TestCase;

import java.util.Arrays;

public class EgyptianFractionsTest extends TestCase {
    EgyptianFractions fractions = new EgyptianFractions();

    public void test1() {
        assertEquals(fractions.build(2L, 3L), Arrays.asList(2L, 6L));
    }

    public void test2() {
        assertEquals(fractions.build(6L, 14L), Arrays.asList(3L, 11L, 231L));
    }

    public void test3() {
        assertEquals(fractions.build(12L, 13L), Arrays.asList(2L, 3L, 12L, 156L));
    }

    public void test4() {
        assertEquals(fractions.build(3L, 4L), Arrays.asList(2L, 4L));
    }

    public void test5() {
        assertEquals(fractions.build(6L, 7L), Arrays.asList(2L, 3L, 42L));
    }

    public void test6() {
        assertEquals(fractions.build(5L, 8L), Arrays.asList(2L, 8L));
    }

    public void test7() {
        assertEquals(fractions.build(123L, 1500L), Arrays.asList(13L, 197L, 1280500L));
    }

    public void test8() {
        assertEquals(fractions.build(6123L, 7451L), Arrays.asList(2L, 4L, 14L, 2939L, 14955066L, 654986696590548L));
    }
}