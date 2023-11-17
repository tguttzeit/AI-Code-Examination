package ChatGPT.BinarySearch.PromptOnly.T2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    private BinarySearch binarySearch;

    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void testBinarySearchElementFound() {
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 5;
        assertTrue(binarySearch.binarySearch(x, sortedNumbers));
    }

    @Test
    public void testBinarySearchElementNotFound() {
        int[] sortedNumbers = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        int x = 5;
        assertFalse(binarySearch.binarySearch(x, sortedNumbers));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        int[] sortedNumbers = {};
        int x = 42;
        assertFalse(binarySearch.binarySearch(x, sortedNumbers));
    }
}
