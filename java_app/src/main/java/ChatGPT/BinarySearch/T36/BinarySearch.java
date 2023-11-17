package ChatGPT.BinarySearch.T36;

public class BinarySearch {
    public boolean binarySearch(int target, int[] sortedArray) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == target) {
                return true;
            } else if (sortedArray[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}

