package Copilot.BinarySearch.T36;

public class BinarySearch {
    public boolean binarySearch(int target, int[] arr) {
        // Implement the binary search algorithm here
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (arr[middle] == target) {
                return true;
            } else if (arr[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return false;
    }

}
