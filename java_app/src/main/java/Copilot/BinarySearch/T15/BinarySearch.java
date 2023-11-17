package Copilot.BinarySearch.T15;

public class BinarySearch {
    public boolean binarySearch(int n, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] == n) {
                return true;
            } else if (arr[middle] < n) {
                start = middle + 1;
            } else if (arr[middle] > n) {
                end = middle - 1;
            }
        }
        if (arr[start] == n) {
            return true;
        } else {
            return false;
        }
    }
}
