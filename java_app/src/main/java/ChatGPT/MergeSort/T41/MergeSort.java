package ChatGPT.MergeSort.T41;

public class MergeSort {

    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Base case: already sorted or empty
        }

        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, temp, left, mid);      // Sort left half
            mergeSort(array, temp, mid + 1, right); // Sort right half
            merge(array, temp, left, mid, right);   // Merge sorted halves
        }
    }

    private void merge(int[] array, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i]; // Copy the original array into a temporary array
        }

        int i = left;     // Pointer for the left subarray
        int j = mid + 1;  // Pointer for the right subarray
        int k = left;     // Pointer for the merged array

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        // Copy the remaining elements from the left subarray, if any
        while (i <= mid) {
            array[k++] = temp[i++];
        }

        // Copy the remaining elements from the right subarray, if any
        while (j <= right) {
            array[k++] = temp[j++];
        }
    }
}

