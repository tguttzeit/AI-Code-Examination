package Copilot.BinarySearch.AIGenerated.T6;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch bs = new BinarySearch();
        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};

        assertTrue(bs.binarySearch(2, arr));
        assertTrue(bs.binarySearch(19, arr));
        assertFalse(bs.binarySearch(10, arr));
    }
}