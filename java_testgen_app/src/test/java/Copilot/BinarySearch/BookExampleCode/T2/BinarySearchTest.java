package Copilot.BinarySearch.BookExampleCode.T2;

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
    public void shouldReturnTrueWhenNumberIsFound() {
        int[] sortedNumbers = {1, 3, 5, 7, 9};
        assertTrue(binarySearch.binarySearch(5, sortedNumbers));
    }

    @Test
    public void shouldReturnFalseWhenNumberIsNotFound() {
        int[] sortedNumbers = {1, 3, 5, 7, 9};
        assertFalse(binarySearch.binarySearch(2, sortedNumbers));
    }

    @Test
    public void shouldReturnFalseWhenArrayIsEmpty() {
        int[] sortedNumbers = {};
        assertFalse(binarySearch.binarySearch(2, sortedNumbers));
    }

}