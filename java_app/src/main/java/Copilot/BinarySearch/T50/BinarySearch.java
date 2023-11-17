package Copilot.BinarySearch.T50;

public class BinarySearch {
    public boolean binarySearch(int value, int[] list) {
        int low = 0;
        int high = list.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (list[mid] == value) {
                return true;
            } else if (list[mid] < value) {
                low = mid + 1;
            } else if (list[mid] > value) {
                high = mid - 1;
            }
        }

        return false;
    }

}
