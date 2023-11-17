package ChatGPT.MergeSort.BookExampleCode.T1;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortSortedArray() {
        int[] inputArray = { 1, 2, 3, 4, 5 };
        int[] expectedArray = { 1, 2, 3, 4, 5 };
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void testMergeSortReverseSortedArray() {
        int[] inputArray = { 5, 4, 3, 2, 1 };
        int[] expectedArray = { 1, 2, 3, 4, 5 };
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void testMergeSortRandomArray() {
        int[] inputArray = { 3, 1, 4, 2, 5 };
        int[] expectedArray = { 1, 2, 3, 4, 5 };
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }
}
