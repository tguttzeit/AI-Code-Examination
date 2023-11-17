package Copilot.BinarySearch.T42;

public class BinarySearch {
    public boolean binarySearch(int value, int[] array) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] < value) {
                low = mid + 1;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
