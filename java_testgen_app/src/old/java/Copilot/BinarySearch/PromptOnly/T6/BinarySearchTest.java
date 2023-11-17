package Copilot.BinarySearch.PromptOnly.T6;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch search = new BinarySearch();

        int[] numbers = {1, 2, 3, 4, 5};
        int x = 3;
        boolean result = search.binarySearch(x, numbers);
        assertTrue(result);

        int[] numbers = {1, 2, 3, 4, 5};
        int x = 6;
        boolean result = search.binarySearch(x, numbers);
        assertFalse(result);

        int[] numbers = {1, 2, 3, 4, 5};
        int x = 5;
        boolean result = search.binarySearch(x, numbers);
        assertTrue(result);
    }
}