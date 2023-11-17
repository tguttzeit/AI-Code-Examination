package ChatGPT.BinarySearch.BookExampleCode.T9;

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
    public void testBinarySearchFound() {
        int[] sortedNumbers = {1, 3, 5, 7, 9, 11};
        int x = 5;
        assertTrue(binarySearch.binarySearch(x, sortedNumbers));
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] sortedNumbers = {1, 3, 5, 7, 9, 11};
        int x = 8;
        assertFalse(binarySearch.binarySearch(x, sortedNumbers));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        int[] sortedNumbers = {};
        int x = 42;
        assertFalse(binarySearch.binarySearch(x, sortedNumbers));
    }
}
