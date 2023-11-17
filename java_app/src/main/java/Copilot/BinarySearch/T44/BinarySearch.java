package Copilot.BinarySearch.T44;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int midpoint = 0;
        while (left <= right) {
            midpoint = (left + right) / 2;
            if (nums[midpoint] == target) {
                return true;
            } else if (nums[midpoint] < target) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        return false;
    }
}
