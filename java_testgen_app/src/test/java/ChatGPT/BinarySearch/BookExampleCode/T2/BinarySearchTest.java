package ChatGPT.BinarySearch.BookExampleCode.T2;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void testBinarySearch_Found() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 3, 5, 7, 9};
        int x = 5;
        assertTrue(binarySearch.binarySearch(x, sortedNumbers));
    }

    @Test
    public void testBinarySearch_NotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 3, 5, 7, 9};
        int x = 4;
        assertFalse(binarySearch.binarySearch(x, sortedNumbers));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {};
        int x = 10;
        assertFalse(binarySearch.binarySearch(x, sortedNumbers));
    }
}
