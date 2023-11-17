package Copilot.BinarySearch.T8;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int middle = left + (right - left) / 2;

            if(nums[middle] == target) {
                return true;
            }
            else if(nums[middle] < target) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }

        return false;
    }
}
