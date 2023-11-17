package Copilot.BinarySearch.AIGenerated.T5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
    private BinarySearch binarySearch;

    @Before
    public void setup() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void testBinarySearch() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        assertTrue(binarySearch.binarySearch(4, arr));
        assertFalse(binarySearch.binarySearch(0, arr));
        assertFalse(binarySearch.binarySearch(7, arr));
    }
}