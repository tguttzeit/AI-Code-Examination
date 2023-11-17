package ChatGPT.BinarySearch.T10;

public class BinarySearch {
    public boolean binarySearch(int target, int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return true; // Target found
            } else if (array[mid] < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return false; // Target not found
    }
}

