package Copilot.MergeSort.T26;

public class MergeSort {
    public void mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        mergeSortHelper(array, 0, array.length - 1);
    }
    private void mergeSortHelper(int[] array, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }
        // recursion rule
        int mid = left + (right - left) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid + 1, right);
        merge(array, left, mid, right);
    }
    private void merge(int[] array, int left, int mid, int right) {
        // create a helper array
        int[] helper = new int[right - left + 1];
        for (int i = 0; i < helper.length; i++) {
            helper[i] = array[left + i];
        }
        // merge two sorted array
        int i = 0;
        int j = mid - left;
        int k = left;
        while (i <= mid - left && j <= right - left) {
            if (helper[i] <= helper[j]) {
                array[k++] = helper[i++];
            } else {
                array[k++] = helper[j++];
            }
        }
        // copy the remaining elements
        while (i <= mid - left) {
            array[k++] = helper[i++];
        }
    }
}
