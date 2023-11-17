package ChatGPT.BinarySearch.AIGenerated.T1;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearch_TargetExistsInArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        assertTrue(binarySearch.binarySearch(target, arr));
    }

    @Test
    public void testBinarySearch_TargetDoesNotExistInArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {2, 4, 6, 8, 10};
        int target = 7;
        assertFalse(binarySearch.binarySearch(target, arr));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {};
        int target = 5;
        assertFalse(binarySearch.binarySearch(target, arr));
    }

    // Add more test cases as needed

}
