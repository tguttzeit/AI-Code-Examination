package Copilot.BinarySearch.PromptOnly.T6;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch search = new BinarySearch();

        int[] numbers = { 1, 2, 3, 4, 5 };
        int x = 3;
        boolean result = search.binarySearch(x, numbers);
        assertTrue(result);

        int[] numbers1 = { 1, 2, 3, 4, 5 };
        int x1 = 6;
        boolean result1 = search.binarySearch(x, numbers);
        assertFalse(result);

        int[] numbers2 = { 1, 2, 3, 4, 5 };
        int x2 = 5;
        boolean result2 = search.binarySearch(x, numbers);
        assertTrue(result);
    }
}