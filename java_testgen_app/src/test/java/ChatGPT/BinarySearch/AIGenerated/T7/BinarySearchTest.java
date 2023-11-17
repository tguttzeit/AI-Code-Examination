package ChatGPT.BinarySearch.AIGenerated.T7;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearchTargetFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        assertTrue(binarySearch.binarySearch(target, arr));
    }

    @Test
    public void testBinarySearchTargetNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {2, 4, 6, 8, 10};
        int target = 5;
        assertFalse(binarySearch.binarySearch(target, arr));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {};
        int target = 9;
        assertFalse(binarySearch.binarySearch(target, arr));
    }
}
