package Copilot.BinarySearch.AIGenerated.T3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch bs = new BinarySearch();

        int[] arr = {1, 2, 3, 4, 5, 6};
        assertTrue(bs.binarySearch(3, arr));

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        assertFalse(bs.binarySearch(7, arr2));

        int[] arr3 = {};
        assertFalse(bs.binarySearch(1, arr3));
    }
}