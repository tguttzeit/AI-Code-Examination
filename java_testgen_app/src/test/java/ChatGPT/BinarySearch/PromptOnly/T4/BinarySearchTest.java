package ChatGPT.BinarySearch.PromptOnly.T4;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearchWithExistingElement() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5};
        int target = 3;
        assertTrue(binarySearch.binarySearch(target, sortedNumbers));
    }

    @Test
    public void testBinarySearchWithNonExistingElement() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5};
        int target = 6;
        assertFalse(binarySearch.binarySearch(target, sortedNumbers));
    }

    @Test
    public void testBinarySearchWithEmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {};
        int target = 3;
        assertFalse(binarySearch.binarySearch(target, sortedNumbers));
    }
}
