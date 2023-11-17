package Copilot.BinarySearch.T9;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (high + low) / 2;

        while (low <= high) {
            if (nums[mid] == target) {
                return true;
            } else if (target > nums[mid]) {
                low = mid + 1;
                mid = (high + low) / 2;
            } else {
                high = mid - 1;
                mid = (high + low) / 2;
            }
        }
        return false;
    }
}
