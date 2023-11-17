package Copilot.BinarySearch.T14;

public class BinarySearch {

    public boolean binarySearch(int target, int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return true;
        }
        if (nums[right] == target) {
            return true;
        }
        return false;
    }
}
