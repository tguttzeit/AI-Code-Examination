package Copilot.BinarySearch.T33;

public class BinarySearch {
    public boolean binarySearch(int value, int[] inputArray) {
        int left = 0;
        int right = inputArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(inputArray[mid] == value) {
                return true;
            } else if(inputArray[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false; // replace this line with your code
    }
}
