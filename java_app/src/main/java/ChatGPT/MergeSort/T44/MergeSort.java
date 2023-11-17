package ChatGPT.MergeSort.T44;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // No need to sort
        }

        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Calculate mid index

            mergeSort(arr, temp, left, mid); // Sort left subarray
            mergeSort(arr, temp, mid + 1, right); // Sort right subarray

            merge(arr, temp, left, mid, right); // Merge two sorted subarrays
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i]; // Copy elements to temporary array
        }

        int i = left; // Pointer for left subarray
        int j = mid + 1; // Pointer for right subarray
        int k = left; // Pointer for merged array

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

        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}

