package ChatGPT.BinarySearch.BookExampleCode.T10;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearchElementFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertTrue(binarySearch.binarySearch(5, sortedNumbers));
    }

    @Test
    public void testBinarySearchElementNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertFalse(binarySearch.binarySearch(11, sortedNumbers));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {};
        assertFalse(binarySearch.binarySearch(5, sortedNumbers));
    }

    @Test
    public void testBinarySearchSingleElementFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {5};
        assertTrue(binarySearch.binarySearch(5, sortedNumbers));
    }

    @Test
    public void testBinarySearchSingleElementNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {10};
        assertFalse(binarySearch.binarySearch(5, sortedNumbers));
    }
}
