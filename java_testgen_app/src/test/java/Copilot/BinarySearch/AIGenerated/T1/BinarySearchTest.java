package Copilot.BinarySearch.AIGenerated.T1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void testBinarySearch() {
        int[] arr = { 1, 2, 3, 4, 5 };
        assertTrue(binarySearch.binarySearch(3, arr));
    }

    @Test
    public void testBinarySearch2() {
        int[] arr = { 1, 2, 3, 4, 5 };
        assertFalse(binarySearch.binarySearch(6, arr));
    }

    @Test
    public void testBinarySearch3() {
        int[] arr = { 1, 2, 3, 4, 5 };
        assertTrue(binarySearch.binarySearch(5, arr));
    }
}