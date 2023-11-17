package Copilot.BinarySearch.T30;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        // Implement the binary search algorithm.
        // The method should return true if the target is found in the array.
        // Return false if it is not found.
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
