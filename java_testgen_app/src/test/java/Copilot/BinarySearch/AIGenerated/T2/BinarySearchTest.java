package Copilot.BinarySearch.AIGenerated.T2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();

        assertTrue(binarySearch.binarySearch(1, new int[] {1, 2, 3, 4, 5}));
        assertFalse(binarySearch.binarySearch(0, new int[] {1, 2, 3, 4, 5}));
        assertTrue(binarySearch.binarySearch(5, new int[] {1, 2, 3, 4, 5}));
    }
}