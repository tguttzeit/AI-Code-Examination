package ChatGPT.BinarySearch.T41;

public class BinarySearch {
    public boolean binarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true; // Element found
            } else if (arr[mid] < target) {
                left = mid + 1; // Discard left half
            } else {
                right = mid - 1; // Discard right half
            }
        }

        return false; // Element not found
    }
}

