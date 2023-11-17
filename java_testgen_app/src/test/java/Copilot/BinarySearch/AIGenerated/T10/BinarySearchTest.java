package Copilot.BinarySearch.AIGenerated.T10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();

        int[] arr = { 1, 2, 3, 4, 5 };
        boolean result = binarySearch.binarySearch(4, arr);

        assertEquals(true, result);
    }

    @Test
    public void testBinarySearch1() {
        BinarySearch binarySearch = new BinarySearch();

        int[] arr = { 1, 2, 3, 4, 5 };
        boolean result = binarySearch.binarySearch(6, arr);

        assertEquals(false, result);
    }

    @Test
    public void testBinarySearch2() {
        BinarySearch binarySearch = new BinarySearch();

        int[] arr = { 1, 2, 3, 4, 5 };
        boolean result = binarySearch.binarySearch(1, arr);

        assertEquals(true, result);
    }
}