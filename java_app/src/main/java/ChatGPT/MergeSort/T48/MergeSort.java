package ChatGPT.MergeSort.T48;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // No need to sort
        }

        int n = arr.length;
        int[] temp = new int[n];
        mergeSort(arr, temp, 0, n - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid);        // Sort left half
            mergeSort(arr, temp, mid + 1, right);   // Sort right half
            merge(arr, temp, left, mid, right);     // Merge both halves
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i]; // Copy elements to temp array
        }

        int i = left;   // Pointer for the left subarray
        int j = mid + 1; // Pointer for the right subarray
        int k = left;   // Pointer for the merged array

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++]; // Copy remaining elements from left subarray
        }
    }
}

