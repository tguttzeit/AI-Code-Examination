package Copilot.BinarySearch.BookExampleCode.T3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch bs = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8};
        assertEquals(true, bs.binarySearch(1, sortedNumbers));
        assertEquals(true, bs.binarySearch(8, sortedNumbers));
        assertEquals(false, bs.binarySearch(9, sortedNumbers));
    }
}