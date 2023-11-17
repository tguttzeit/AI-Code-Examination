package Copilot.BinarySearch.T35;

public class BinarySearch {

    public boolean binarySearch(int target, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }


}
