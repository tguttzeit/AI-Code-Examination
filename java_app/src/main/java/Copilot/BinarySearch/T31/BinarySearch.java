package Copilot.BinarySearch.T31;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        // Implement the binary search logic here
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return false;
    }
}
