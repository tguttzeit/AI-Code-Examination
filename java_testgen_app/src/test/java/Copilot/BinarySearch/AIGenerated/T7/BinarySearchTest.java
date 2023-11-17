package Copilot.BinarySearch.AIGenerated.T7;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
    private BinarySearch binarySearch;

    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void testBinarySearch() {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(binarySearch.binarySearch(3, arr));
    }

    @Test
    public void testBinarySearchWithEmptyArray() {
        int[] arr = {};
        assertFalse(binarySearch.binarySearch(3, arr));
    }

    @Test
    public void testBinarySearchWithNonExistentElement() {
        int[] arr = {1, 2, 3, 4, 5};
        assertFalse(binarySearch.binarySearch(6, arr));
    }
}