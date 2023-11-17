package ChatGPT.MergeSort.T3;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: already sorted or empty array
        }

        int n = arr.length;
        int[] temp = new int[n];
        mergeSortHelper(arr, temp, 0, n - 1);
    }

    private void mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return; // Base case: single element
        }

        int mid = left + (right - left) / 2;

        // Recursively sort the two halves
        mergeSortHelper(arr, temp, left, mid);
        mergeSortHelper(arr, temp, mid + 1, right);

        // Merge the sorted halves
        merge(arr, temp, left, mid, right);
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy data to temporary arrays
        System.arraycopy(arr, left, temp, left, right - left + 1);

        int i = left; // Initial index of first subarray
        int j = mid + 1; // Initial index of second subarray
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

        // Copy the remaining elements of the first subarray
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        // Copy the remaining elements of the second subarray
        while (j <= right) {
            arr[k] = temp[j];
            j++;
            k++;
        }
    }
}

