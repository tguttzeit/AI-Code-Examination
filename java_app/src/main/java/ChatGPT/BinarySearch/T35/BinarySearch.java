package ChatGPT.BinarySearch.T35;

public class BinarySearch {
    public boolean binarySearch(int target, int[] sortedArray) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == target) {
                return true; // Found the target
            } else if (sortedArray[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        return false; // Target not found
    }
}

