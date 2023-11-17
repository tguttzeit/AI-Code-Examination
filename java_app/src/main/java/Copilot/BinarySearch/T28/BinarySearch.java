package Copilot.BinarySearch.T28;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        // Implement the binary search logic here
        // Return true if the target is found, or false if it is not found
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (high + low)/2;
            if(nums[mid] == target){
                return true;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            }
        }
        return false;
    }
}
