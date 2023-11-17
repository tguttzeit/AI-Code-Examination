package ChatGPT.MergeSort.T40;

public class MergeSort {

    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Base case: already sorted or empty
        }

        int length = array.length;
        int[] tempArray = new int[length];
        mergeSortHelper(array, tempArray, 0, length - 1);
    }

    private void mergeSortHelper(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Calculate mid point

            // Recursively sort the two halves
            mergeSortHelper(array, tempArray, left, mid);
            mergeSortHelper(array, tempArray, mid + 1, right);

            // Merge the sorted halves
            merge(array, tempArray, left, mid, right);
        }
    }

    private void merge(int[] array, int[] tempArray, int left, int mid, int right) {
        // Copy elements to temporary array
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }

        int i = left; // Pointer for left subarray
        int j = mid + 1; // Pointer for right subarray
        int k = left; // Pointer for merged array

        // Merge two subarrays back into the original array
        while (i <= mid && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                array[k++] = tempArray[i++];
            } else {
                array[k++] = tempArray[j++];
            }
        }

        // Copy remaining elements from left subarray if any
        while (i <= mid) {
            array[k++] = tempArray[i++];
        }
    }
}
