package ChatGPT.MergeSort.T29;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted or nothing to sort
        }

        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy elements to temp arrays
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;     // Pointer for the left subarray
        int j = mid + 1;  // Pointer for the right subarray
        int k = left;     // Pointer for the merged array

        // Merge the two subarrays
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copy remaining elements from the left subarray
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }
}
