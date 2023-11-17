package Copilot.BinarySearch.T12;

public class BinarySearch {
    public boolean binarySearch(int value, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int middle = (left + right) / 2;

        while (left <= right) {
            if (arr[middle] == value) {
                return true;
            } else if (arr[middle] > value) {
                right = middle - 1;
                middle = (left + right) / 2;
            } else if (arr[middle] < value) {
                left = middle + 1;
                middle = (left + right) / 2;
            }
        }
        return false;
    }
}
