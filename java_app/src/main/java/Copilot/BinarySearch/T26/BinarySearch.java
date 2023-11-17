package Copilot.BinarySearch.T26;

public class BinarySearch {
    public boolean binarySearch(int value, int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return true;
            }
            if (array[middle] < value) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}
