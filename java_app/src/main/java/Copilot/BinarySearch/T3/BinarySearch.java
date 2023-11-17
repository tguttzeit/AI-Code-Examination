package Copilot.BinarySearch.T3;

public class BinarySearch {
    public boolean binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return true;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return false;
    }

}
