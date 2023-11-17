package Copilot.BinarySearch.BookExampleCode.T10;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch bs = new BinarySearch();
        int[] numbers = {1, 2, 3, 4, 5};
        assertTrue(bs.binarySearch(2, numbers));
        assertFalse(bs.binarySearch(6, numbers));
        assertFalse(bs.binarySearch(0, numbers));
    }
}