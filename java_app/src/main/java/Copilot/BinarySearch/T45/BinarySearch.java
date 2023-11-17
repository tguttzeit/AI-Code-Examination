package Copilot.BinarySearch.T45;

public class BinarySearch {

    public boolean binarySearch(int target, int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) {
                low = mid + 1;
                mid = (low + high) / 2;
            } else {
                high = mid - 1;
                mid = (low + high) / 2;
            }
        }
        return false;
    }
}
