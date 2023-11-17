package Copilot.BinarySearch.AIGenerated.T8;

import org.junit.Assert;
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
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Assert.assertTrue(binarySearch.binarySearch(4, arr));
        Assert.assertFalse(binarySearch.binarySearch(6, arr));
        Assert.assertTrue(binarySearch.binarySearch(5, arr));
    }
}