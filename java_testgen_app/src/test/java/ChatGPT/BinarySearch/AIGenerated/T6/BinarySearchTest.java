package ChatGPT.BinarySearch.AIGenerated.T6;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    // Test case 1: Target found in the middle of the array
    @Test
    public void testBinarySearch_TargetInMiddle() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        assertTrue(binarySearch.binarySearch(target, arr));
    }

    // Test case 2: Target found at the beginning of the array
    @Test
    public void testBinarySearch_TargetAtStart() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 1;
        assertTrue(binarySearch.binarySearch(target, arr));
    }

    // Test case 3: Target not found in the array
    @Test
    public void testBinarySearch_TargetNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 6;
        assertFalse(binarySearch.binarySearch(target, arr));
    }
}
