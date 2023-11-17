package Copilot.QuickSort.BookExampleCode.T9;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuickSortTest {
    private QuickSort quickSort = new QuickSort();

    @Test
    public void sortTest1() {
        int[] numbers = { 5, 4, 3, 2, 1 };
        quickSort.sort(numbers);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, numbers);
    }

    @Test
    public void sortTest2() {
        int[] numbers = { 2, 3, 4, 5, 1 };
        quickSort.sort(numbers);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, numbers);
    }

    @Test
    public void sortTest3() {
        int[] numbers = { 1, 2, 3, 4, 5 };
        quickSort.sort(numbers);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, numbers);
    }

}