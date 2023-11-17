package ChatGPT.MergeSort.T9;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: already sorted or empty
        }

        int n = arr.length;
        int[] temp = new int[n];
        mergeSortHelper(arr, temp, 0, n - 1);
    }

    private void mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Calculate mid point

            mergeSortHelper(arr, temp, left, mid); // Sort left subarray
            mergeSortHelper(arr, temp, mid + 1, right); // Sort right subarray

            merge(arr, temp, left, mid, right); // Merge sorted subarrays
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i]; // Copy elements to the temporary array
        }

        int i = left; // Index for left subarray
        int j = mid + 1; // Index for right subarray
        int k = left; // Index for merged array

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements from the left subarray
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}
