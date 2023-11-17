package Copilot.BinarySearch.T23;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // While the left index is less than or equal to the right index
        while (left <= right) {

            // Find the middle index
            int middle = (left + right) / 2;

            // If the target is less than the middle element
            if (target < nums[middle]) {

                // Set the right index to the middle index - 1
                right = middle - 1;

                // If the target is greater than the middle element
            } else if (target > nums[middle]) {

                // Set the left index to the middle index + 1
                left = middle + 1;

                // If the target is equal to the middle element
            } else {

                // Return true
                return true;
            }
        }

        // Return false
        return false;
    }
}
