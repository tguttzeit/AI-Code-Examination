package ChatGPT.BinarySearch.T23;

public class BinarySearch {

    public boolean binarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true; // Found the target
            } else if (arr[mid] < target) {
                left = mid + 1; // Adjust the search range to the right half
            } else {
                right = mid - 1; // Adjust the search range to the left half
            }
        }

        return false; // Target not found
    }
}

