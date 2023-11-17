package Copilot.BinarySearch.T2;

public class BinarySearch {
    public boolean binarySearch(int value, int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (high >= low) {
            int middle = (low + high) / 2;
            if (value == array[middle]) {
                return true;
            }
            if (value < array[middle]) {
                high = middle - 1;
            }
            if (value > array[middle]) {
                low = middle + 1;
            }
        }
        return false;
    }

}
