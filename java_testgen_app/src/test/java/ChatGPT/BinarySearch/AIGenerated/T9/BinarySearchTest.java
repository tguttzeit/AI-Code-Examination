package ChatGPT.BinarySearch.AIGenerated.T9;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    private BinarySearch binarySearch;

    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void testBinarySearch_TargetExistsInArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;
        assertTrue(binarySearch.binarySearch(target, arr));
    }

    @Test
    public void testBinarySearch_TargetDoesNotExistInArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 11;
        assertFalse(binarySearch.binarySearch(target, arr));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        int[] arr = {};
        int target = 5;
        assertFalse(binarySearch.binarySearch(target, arr));
    }
}
