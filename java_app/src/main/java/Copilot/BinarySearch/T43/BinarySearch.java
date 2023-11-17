package Copilot.BinarySearch.T43;

public class BinarySearch {
    public static boolean binarySearch(int n, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middleIndex = (left + right) / 2;
            if (arr[middleIndex] == n) {
                return true;
            }
            if (n < arr[middleIndex]) {
                right = middleIndex - 1;
            } else {
                left = middleIndex + 1;
            }
        }
        return false;
    }

}
