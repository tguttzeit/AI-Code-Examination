package Copilot.BinarySearch.T27;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
            mid = (start + end) / 2;
        }
        return false;
    }
}
