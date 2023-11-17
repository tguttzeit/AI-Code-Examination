package Copilot.MergeSort.T35;

public class MergeSort {
    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }
    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right)/2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, right);
    }
    private void merge(int[] array, int[] helper, int left, int right) {
        int mid = (left + right)/2;
        int leftIndex = left;
        int rightIndex = mid + 1;
        int cur = left;
        while (leftIndex <= mid && rightIndex <= right) {
            if (array[leftIndex] <= array[rightIndex]) {
                helper[cur++] = array[leftIndex++];
            } else {
                helper[cur++] = array[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            helper[cur++] = array[leftIndex++];
        }
        for (int i = left; i <= right; i++) {
            array[i] = helper[i];
        }
    }
}
