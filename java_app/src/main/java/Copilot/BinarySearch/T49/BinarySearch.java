package Copilot.BinarySearch.T49;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int middle;

        while (start <= end) {
            middle = (start + end) / 2;
            if (nums[middle] == target) {
                return true;
            } else if (target < nums[middle]) {
                end = middle - 1;
            } else if (target > nums[middle]) {
                start = middle + 1;
            }
        }

        return false;
    }
}
