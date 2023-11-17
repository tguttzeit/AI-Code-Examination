package Copilot.BinarySearch.AIGenerated.T1;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        // Perform binary search
        while (low <= high) {
            mid = low + (high - low) / 2;
            // If target is greater, ignore left half
            if (nums[mid] < target) {
                low = mid + 1;
            }
            // If target is smaller, ignore right half
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            // Target is found
            else {
                return true;
            }
        }
        // Target not found
        return false;
    }

}
