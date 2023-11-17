package ChatGPT.QuickSort.BookExampleCode.T1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnit4.class)
public class QuickSortTest {

    @Test
    public void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testUnsortedArray() {
        int[] input = {5, 3, 1, 4, 2};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }
}
