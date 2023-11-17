package ChatGPT.MergeSort.BookExampleCode.T8;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] inputArray = {};
        int[] expectedArray = {};
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void testMergeSortWithSortedArray() {
        int[] inputArray = { 1, 2, 3, 4, 5 };
        int[] expectedArray = { 1, 2, 3, 4, 5 };
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void testMergeSortWithRandomArray() {
        int[] inputArray = { 5, 2, 9, 1, 5, 6 };
        int[] expectedArray = { 1, 2, 5, 5, 6, 9 };
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }
}
