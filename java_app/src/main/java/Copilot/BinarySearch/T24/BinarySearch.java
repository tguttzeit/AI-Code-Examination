package Copilot.BinarySearch.T24;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;

        while (left <= right) {
            middle = (left + right) / 2;

            if (target == nums[middle]) {
                return true;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }
        }

        return false;
    }

}
