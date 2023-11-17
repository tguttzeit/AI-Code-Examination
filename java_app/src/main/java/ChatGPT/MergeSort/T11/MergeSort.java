package ChatGPT.MergeSort.T11;

public class MergeSort {
    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // No need to sort
        }

        int[] tempArray = new int[array.length];
        mergeSort(array, tempArray, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(array, tempArray, left, middle);
            mergeSort(array, tempArray, middle + 1, right);
            merge(array, tempArray, left, middle, right);
        }
    }

    private void merge(int[] array, int[] tempArray, int left, int middle, int right) {
        // Copy data to temporary arrays
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }

        int i = left; // Initial index of first subarray
        int j = middle + 1; // Initial index of second subarray
        int k = left; // Initial index of merged subarray

        // Merge the subarrays
        while (i <= middle && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of left subarray
        while (i <= middle) {
            array[k] = tempArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of right subarray
        while (j <= right) {
            array[k] = tempArray[j];
            j++;
            k++;
        }
    }
}

