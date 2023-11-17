package Copilot.BinarySearch.PromptOnly.T4;

public class BinarySearchTest {
    @org.junit.Test
    public void binarySearch() {
        BinarySearch test = new BinarySearch();
        int[] testArray = {1, 2, 3, 4, 5, 6};
        assert test.binarySearch(2, testArray) == true;
        assert test.binarySearch(7, testArray) == false;
        assert test.binarySearch(1, testArray) == true;
    }
}