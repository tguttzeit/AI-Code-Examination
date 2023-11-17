package Copilot.BinarySearch.T13;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = right / 2;
        while (left <= right) {
            if (nums[mid] > target) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else if (nums[mid] < target) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                return true;
            }
        }
        return false;
    }
}
