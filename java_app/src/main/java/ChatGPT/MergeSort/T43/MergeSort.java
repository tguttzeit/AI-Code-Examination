package ChatGPT.MergeSort.T43;

public class MergeSort {
    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Base case: already sorted or empty array
        }

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        // Fill left and right subarrays
        System.arraycopy(array, 0, leftArray, 0, mid);
        System.arraycopy(array, mid, rightArray, 0, array.length - mid);

        // Recursively sort left and right subarrays
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Merge the sorted subarrays
        merge(array, leftArray, rightArray);
    }

    private void merge(int[] result, int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        // Compare elements from left and right subarrays and merge
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        // Copy remaining elements from left and right subarrays
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
    }
}

