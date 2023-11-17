package Copilot.BinarySearch.T39;

public class BinarySearch {
    public static boolean binarySearch(int target, int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + ((end - start) / 2);
            if(nums[mid] == target){
                return true;
            } else if(nums[mid] < target){
                start = mid + 1;
            } else if(nums[mid] > target){
                end = mid - 1;
            }
        }
        return false;
    }
}
