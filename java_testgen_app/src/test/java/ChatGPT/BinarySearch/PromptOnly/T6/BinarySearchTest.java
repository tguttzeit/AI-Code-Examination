package ChatGPT.BinarySearch.PromptOnly.T6;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    private BinarySearch binarySearch;

    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void testBinarySearchExistingElement() {
        int[] sortedNumbers = {1, 2, 3, 4, 5};
        int target = 3;
        assertTrue(binarySearch.binarySearch(target, sortedNumbers));
    }

    @Test
    public void testBinarySearchNonExistingElement() {
        int[] sortedNumbers = {10, 20, 30, 40, 50};
        int target = 25;
        assertFalse(binarySearch.binarySearch(target, sortedNumbers));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        int[] sortedNumbers = {};
        int target = 10;
        assertFalse(binarySearch.binarySearch(target, sortedNumbers));
    }
}
