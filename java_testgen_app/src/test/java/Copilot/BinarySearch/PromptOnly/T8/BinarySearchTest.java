package Copilot.BinarySearch.PromptOnly.T8;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(1, arr));
        System.out.println(bs.binarySearch(2, arr));
        System.out.println(bs.binarySearch(3, arr));
        System.out.println(bs.binarySearch(4, arr));
        System.out.println(bs.binarySearch(5, arr));
        System.out.println(bs.binarySearch(0, arr));
    }
}