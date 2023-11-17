package Copilot.BinarySearch.T46;

public class BinarySearch {
    public static boolean binarySearch(int value, int[] array) {
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right)/2;
            if (array[mid] == value){
                return true;
            }
            if (array[mid] > value){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}
