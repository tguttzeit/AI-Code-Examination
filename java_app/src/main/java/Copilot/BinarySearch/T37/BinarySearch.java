package Copilot.BinarySearch.T37;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;

        // While the left index is less than or equal to the right index.
        while (left <= right) {
            // Set the middle index to the average of the left and right indexes.
            middle = (left + right) / 2;

            // If the target is equal to the value at the middle index, return true.
            if (target == nums[middle]) {
                return true;
            }

            // If the target is less than the value at the middle index, set the right index to the middle index minus one.
            if (target < nums[middle]) {
                right = middle - 1;
            }

            // If the target is greater than the value at the middle index, set the left index to the middle index plus one.
            if (target > nums[middle]) {
                left = middle + 1;
            }
        }

        // Return false if the target is not found.
        return false;
    }
}
