package ChatGPT.BinarySearch.BookExampleCode.T6;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearchElementExists() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 6;
        assertTrue(binarySearch.binarySearch(target, sortedNumbers));
    }

    @Test
    public void testBinarySearchElementDoesNotExist() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 11;
        assertFalse(binarySearch.binarySearch(target, sortedNumbers));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {};
        int target = 5;
        assertFalse(binarySearch.binarySearch(target, sortedNumbers));
    }
}
