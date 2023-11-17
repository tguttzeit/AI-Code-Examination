package ChatGPT.BinarySearch.BookExampleCode.T7;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {
    private BinarySearch binarySearch;

    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void testBinarySearch_ElementExistsAtBeginning() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertTrue(binarySearch.binarySearch(1, numbers));
    }

    @Test
    public void testBinarySearch_ElementExistsInMiddle() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertTrue(binarySearch.binarySearch(3, numbers));
    }

    @Test
    public void testBinarySearch_ElementExistsAtEnd() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertTrue(binarySearch.binarySearch(5, numbers));
    }

    @Test
    public void testBinarySearch_ElementDoesNotExist() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertFalse(binarySearch.binarySearch(6, numbers));
    }
}
