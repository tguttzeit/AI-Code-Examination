package Copilot.BinarySearch.T29;

public class BinarySearch {
    public boolean binarySearch(int x, int[] sortedArray) {
        int low = 0;
        int high = sortedArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] == x) {
                return true;
            } else if (sortedArray[mid] < x) {
                low = mid + 1;
            } else if (sortedArray[mid] > x) {
                high = mid - 1;
            }
        }
        return false;
    }
}
