package Copilot.BinarySearch.T18;

public class BinarySearch {

    public static boolean binarySearch(int target, int[] array) {
        int low = 0;
        int high = array.length - 1;
        int middle = (high + low) / 2;

        while (low <= high) {
            if (array[middle] < target) {
                low = middle + 1;
            } else if (array[middle] > target) {
                high = middle - 1;
            } else {
                return true;
            }
            middle = (high + low) / 2;
        }
        return false;
    }
}
