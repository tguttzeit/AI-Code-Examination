package ChatGPT.MergeSort.T17;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: array is already sorted or empty
        }
        
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return; // Base case: subarray has 1 or 0 elements
        }

        int mid = left + (right - left) / 2; // Calculate mid index

        mergeSort(arr, temp, left, mid); // Sort left half
        mergeSort(arr, temp, mid + 1, right); // Sort right half

        merge(arr, temp, left, mid, right); // Merge two sorted halves
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy elements to temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left; // Index for the left subarray
        int j = mid + 1; // Index for the right subarray
        int k = left; // Index for the merged array

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

        // Copy remaining elements from the left subarray
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}

