package Copilot.BinarySearch.PromptOnly.T10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {
    // Test case 1
    @Test
    public void testBinarySearch1() {
        BinarySearch bs = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7};
        int x = 3;
        boolean result = bs.binarySearch(x, sortedNumbers);
        assertEquals(true, result);
    }

    // Test case 2
    @Test
    public void testBinarySearch2() {
        BinarySearch bs = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7};
        int x = 8;
        boolean result = bs.binarySearch(x, sortedNumbers);
        assertEquals(false, result);
    }

    // Test case 3
    @Test
    public void testBinarySearch3() {
        BinarySearch bs = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7};
        int x = 1;
        boolean result = bs.binarySearch(x, sortedNumbers);
        assertEquals(true, result);
    }

}