package Copilot.MergeSort.PromptOnly.T1;

import ChatGPT.MergeSort.PromptOnly.T3.MergeSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {


    @Test
    public void testMergeSort() {
        int[] array = { 3, 5, 1, 4, 2 };
        int[] expected = { 1, 2, 3, 4, 5 };
        new MergeSort().mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] array = {};
        int[] expected = {};
        new MergeSort().mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortWithOneElement() {
        int[] array = { 1 };
        int[] expected = { 1 };
        new MergeSort().mergeSort(array);
        assertArrayEquals(expected, array);
    }
}
