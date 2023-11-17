package ChatGPT.BinarySearch.PromptOnly.T1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    private BinarySearch binarySearch;

    @Before
    public void setUp() {
        // Initialize the BinarySearch object before each test.
        binarySearch = new BinarySearch();
    }

    @Test
    public void testBinarySearchElementInArray() {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        assertTrue(binarySearch.binarySearch(target, sortedArray));
    }

    @Test
    public void testBinarySearchElementNotInArray() {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 10;
        assertFalse(binarySearch.binarySearch(target, sortedArray));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        int[] sortedArray = {};
        int target = 7;
        assertFalse(binarySearch.binarySearch(target, sortedArray));
    }
}
