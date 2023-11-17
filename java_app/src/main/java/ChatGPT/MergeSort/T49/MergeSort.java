package ChatGPT.MergeSort.T49;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: already sorted or empty array
        }

        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, temp, left, mid); // Sort left half
            mergeSort(arr, temp, mid + 1, right); // Sort right half

            merge(arr, temp, left, mid, right); // Merge the two halves
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy data to temporary arrays
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left; // Initial index of left subarray
        int j = mid + 1; // Initial index of right subarray
        int k = left; // Initial index of merged subarray

        // Merge the two subarrays
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

        // Copy the remaining elements of left subarray, if any
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}
