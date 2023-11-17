package Copilot.BinarySearch.T7;

public class BinarySearch {
    public static boolean binarySearch(int value, int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (int) Math.floor((start + end) / 2);
            if (array[mid] == value) return true;
            else if (array[mid] < value) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
