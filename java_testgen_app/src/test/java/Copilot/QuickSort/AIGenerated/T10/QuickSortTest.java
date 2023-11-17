package Copilot.QuickSort.AIGenerated.T10;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
    private final int[] sortedArray = {1, 2, 3, 4, 5};
    private final int[] unsortedArray = {5, 4, 3, 2, 1};
    private final int[] emptyArray = {};
    private final int[] oneElementArray = {1};

    @Test
    public void sort() {
        QuickSort quickSort = new QuickSort();

        quickSort.sort(sortedArray);
        assertArrayEquals(sortedArray, sortedArray);

        quickSort.sort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);

        quickSort.sort(emptyArray);
        assertArrayEquals(emptyArray, emptyArray);

        quickSort.sort(oneElementArray);
        assertArrayEquals(oneElementArray, oneElementArray);
    }
}