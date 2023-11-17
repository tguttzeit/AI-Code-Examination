package Copilot.QuickSort.PromptOnly.T8;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {
    QuickSort qs = new QuickSort();

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5};
        qs.sort(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void test2() {
        int[] arr = {5, 4, 3, 2, 1};
        qs.sort(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void test3() {
        int[] arr = {5, 4, 2, 3, 1};
        qs.sort(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

}