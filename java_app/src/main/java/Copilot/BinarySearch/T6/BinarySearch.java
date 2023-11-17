package Copilot.BinarySearch.T6;

public class BinarySearch {

    public static boolean binarySearch(int target, int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (end - start) / 2 + start;
            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }


}
