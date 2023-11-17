package Copilot.MergeSort.T29;

public class MergeSort {
    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        // Base case
        if (left >= right) {
            return;
        }

        // Recursion rule
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, right);
    }

    private void merge(int[] array, int[] helper, int left, int right) {
        // Copy array[left, right] to helper[left, right]
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }

        // Merge two sorted arrays
        int mid = left + (right - left) / 2;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
    }
}
