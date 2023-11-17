package Copilot.BinarySearch.T48;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}
