package Copilot.BinarySearch.AIGenerated.T4;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();

        int[] arr = {1, 2, 3, 4, 5};
        int target = 4;

        assertTrue(binarySearch.binarySearch(target, arr));
    }
}