package ChatGPT.BinarySearch.AIGenerated.T10;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearchTargetFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertTrue(binarySearch.binarySearch(5, arr));
    }

    @Test
    public void testBinarySearchTargetNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        assertFalse(binarySearch.binarySearch(5, arr));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {};
        assertFalse(binarySearch.binarySearch(5, arr));
    }
}
