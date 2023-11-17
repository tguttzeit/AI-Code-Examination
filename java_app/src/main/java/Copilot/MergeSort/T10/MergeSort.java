package Copilot.MergeSort.T10;

public class MergeSort {
    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, temp, 0, arr.length - 1);
    }

    public void mergeSortHelper(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSortHelper(arr, temp, leftStart, middle);
        mergeSortHelper(arr, temp, middle + 1, rightEnd);
        mergeHalves(arr, temp, leftStart, rightEnd);
    }

    public void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        // Size of the merged array
        int size = rightEnd - leftStart + 1;

        // Left and right index
        int left = leftStart;
        int right = rightStart;

        // Index of the temp array
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        // Copy the remaining elements of left array into temp array
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);

        // Copy the remaining elements of right array into temp array
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);

        // Copy the elements of temp array into original array
        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }
}
