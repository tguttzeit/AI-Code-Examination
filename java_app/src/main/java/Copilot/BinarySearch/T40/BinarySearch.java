package Copilot.BinarySearch.T40;

public class BinarySearch {
    public static boolean binarySearch(int target, int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else {
                start = mid + 1;
                mid = (start + end) / 2;
            }
        }
        return false;
    }
}
