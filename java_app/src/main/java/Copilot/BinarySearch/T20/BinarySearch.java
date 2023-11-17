package Copilot.BinarySearch.T20;

public class BinarySearch {
    public boolean binarySearch(int target, int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if(numbers[middle] == target) {
                return true;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;

    }
}
