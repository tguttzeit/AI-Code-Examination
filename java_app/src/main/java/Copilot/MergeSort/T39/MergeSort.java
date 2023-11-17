package Copilot.MergeSort.T39;

public class MergeSort {
    // Merge sort method
    public void mergeSort(int[] arr) {
        // Base case
        if (arr.length < 2) {
            return;
        }

        // Divide array into left and right halves
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        // Recursively sort the left and right halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted left and right halves
        merge(arr, left, right);
    }

    // Merge method
    private void merge(int[] arr, int[] left, int[] right) {
        // Indexes
        int i = 0;
        int j = 0;
        int k = 0;

        // Merge the left and right halves
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
            }
        }

        // Merge the remaining elements
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
