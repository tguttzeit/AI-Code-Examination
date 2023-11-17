package Copilot.BinarySearch.T22;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }

        return false;
    }

}
