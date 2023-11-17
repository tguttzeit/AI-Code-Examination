package Copilot.BinarySearch.T1;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        // Implement the binary search algorithm here
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] < target)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return false;
    }

}





