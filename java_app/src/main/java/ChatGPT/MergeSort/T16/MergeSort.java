package ChatGPT.MergeSort.T16;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: already sorted or empty
        }

        int length = arr.length;
        int[] temp = new int[length]; // Temporary array for merging

        mergeSortHelper(arr, temp, 0, length - 1);
    }

    private void mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSortHelper(arr, temp, left, middle); // Sort left half
            mergeSortHelper(arr, temp, middle + 1, right); // Sort right half

            merge(arr, temp, left, middle, right); // Merge two halves
        }
    }

    private void merge(int[] arr, int[] temp, int left, int middle, int right) {
        // Copy data to temporary arrays
        System.arraycopy(arr, left, temp, left, right - left + 1);

        int i = left; // Initial index of first subarray
        int j = middle + 1; // Initial index of second subarray
        int k = left; // Initial index of merged subarray

        while (i <= middle && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of left subarray (if any)
        while (i <= middle) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        // Copy the remaining elements of right subarray (if any)
        while (j <= right) {
            arr[k] = temp[j];
            j++;
            k++;
        }
    }
}

