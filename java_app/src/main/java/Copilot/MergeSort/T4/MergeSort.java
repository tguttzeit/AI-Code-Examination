package Copilot.MergeSort.T4;

public class MergeSort {
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Divide the array into two halves
            int mid = (left + right) / 2;

            // Sort the left half
            mergeSort(arr, left, mid);

            // Sort the right half
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Create temp arrays
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        // Copy data to temp arrays
        for (int i = 0; i < leftSize; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < rightSize; j++)
            rightArr[j] = arr[mid + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArr
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArr
        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
