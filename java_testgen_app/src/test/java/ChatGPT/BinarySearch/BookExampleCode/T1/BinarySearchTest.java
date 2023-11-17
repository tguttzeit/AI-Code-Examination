package ChatGPT.BinarySearch.BookExampleCode.T1;

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
    public void testBinarySearchFound() {
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertTrue(binarySearch.binarySearch(5, sortedNumbers));
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] sortedNumbers = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        assertFalse(binarySearch.binarySearch(5, sortedNumbers));
    }

    @Test
    public void testBinarySearchEdgeCases() {
        int[] emptyArray = {};
        assertFalse(binarySearch.binarySearch(5, emptyArray));

        int[] singleElementArray = {42};
        assertTrue(binarySearch.binarySearch(42, singleElementArray));

        int[] largeArray = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            largeArray[i] = i * 2;
        }
        assertTrue(binarySearch.binarySearch(5000, largeArray));
    }
}
