package ChatGPT.QuickSort.PromptOnly.T3;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testSortEmptyArray() {
        QuickSort sorter = new QuickSort();
        int[] arr = {};
        sorter.sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortAlreadySortedArray() {
        QuickSort sorter = new QuickSort();
        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortReverseSortedArray() {
        QuickSort sorter = new QuickSort();
        int[] arr = {5, 4, 3, 2, 1};
        sorter.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }
}

