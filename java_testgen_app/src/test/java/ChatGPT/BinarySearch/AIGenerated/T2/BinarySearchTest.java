package ChatGPT.BinarySearch.AIGenerated.T2;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearch_TargetFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 5;
        assertTrue(binarySearch.binarySearch(target, arr));
    }

    @Test
    public void testBinarySearch_TargetNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {2, 4, 6, 8, 10};
        int target = 7;
        assertFalse(binarySearch.binarySearch(target, arr));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {};
        int target = 42;
        assertFalse(binarySearch.binarySearch(target, arr));
    }
}
