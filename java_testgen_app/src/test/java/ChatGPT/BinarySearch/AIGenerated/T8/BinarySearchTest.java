package ChatGPT.BinarySearch.AIGenerated.T8;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearch_TargetExistsInArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 4;
        boolean result = binarySearch.binarySearch(target, arr);
        assertTrue(result);
    }

    @Test
    public void testBinarySearch_TargetNotInArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 8;
        boolean result = binarySearch.binarySearch(target, arr);
        assertFalse(result);
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {};
        int target = 42;
        boolean result = binarySearch.binarySearch(target, arr);
        assertFalse(result);
    }
}
