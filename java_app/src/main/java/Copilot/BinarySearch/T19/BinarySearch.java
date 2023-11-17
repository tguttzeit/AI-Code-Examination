package Copilot.BinarySearch.T19;

public class BinarySearch {
    public boolean binarySearch(int key, int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // find the middle index
            int middle = (low + high) / 2;
            // if the middle index is the key, return true
            if (arr[middle] == key) {
                return true;
                // if the key is less than the middle index, set the high to the middle - 1
            } else if (arr[middle] > key) {
                high = middle - 1;
                // if the key is greater than the middle index, set the low to the middle + 1
            } else {
                low = middle + 1;
            }
        }
        // return false if the key is not found
        return false;
    }
}
