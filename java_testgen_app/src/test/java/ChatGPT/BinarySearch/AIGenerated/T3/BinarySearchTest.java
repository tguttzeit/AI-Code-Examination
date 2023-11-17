package ChatGPT.BinarySearch.AIGenerated.T3;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearch_TargetFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;

        boolean result = binarySearch.binarySearch(target, arr);

        assertTrue(result);
    }

    @Test
    public void testBinarySearch_TargetNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 11;

        boolean result = binarySearch.binarySearch(target, arr);

        assertFalse(result);
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {};
        int target = 5;

        boolean result = binarySearch.binarySearch(target, arr);

        assertFalse(result);
    }
}
