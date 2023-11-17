package ChatGPT.BinarySearch.BookExampleCode.T4;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearchFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 3, 5, 7, 9, 11, 13};

        assertTrue(binarySearch.binarySearch(7, sortedNumbers));
    }

    @Test
    public void testBinarySearchNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {2, 4, 6, 8, 10};

        assertFalse(binarySearch.binarySearch(7, sortedNumbers));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {};

        assertFalse(binarySearch.binarySearch(5, sortedNumbers));
    }
}
