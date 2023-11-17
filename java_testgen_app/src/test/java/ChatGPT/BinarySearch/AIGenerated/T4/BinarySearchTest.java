package ChatGPT.BinarySearch.AIGenerated.T4;

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
    public void testBinarySearchFound() {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 5;
        assertTrue(binarySearch.binarySearch(target, arr));
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] arr = {2, 4, 6, 8, 10};
        int target = 7;
        assertFalse(binarySearch.binarySearch(target, arr));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        int[] arr = {};
        int target = 42;
        assertFalse(binarySearch.binarySearch(target, arr));
    }
}
