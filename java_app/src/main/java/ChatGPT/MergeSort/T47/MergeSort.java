package ChatGPT.MergeSort.T47;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted or empty array
        }

        int n = arr.length;
        int[] temp = new int[n];
        mergeSortHelper(arr, temp, 0, n - 1);
    }

    private void mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // Recursively sort the left and right halves
            mergeSortHelper(arr, temp, left, mid);
            mergeSortHelper(arr, temp, mid + 1, right);

            // Merge the sorted halves
            merge(arr, temp, left, mid, right);
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy data to temp arrays
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        // Merge two subarrays back into the original array
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

        // Copy the remaining elements of the left subarray, if any
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}
