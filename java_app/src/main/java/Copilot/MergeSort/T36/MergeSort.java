package Copilot.MergeSort.T36;

public class MergeSort {
    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        mergeSort(array, 0, array.length-1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int mid = left + (right-left)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] helper = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                helper[index++] = array[i++];
            } else {
                helper[index++] = array[j++];
            }
        }
        while (i <= mid) {
            helper[index++] = array[i++];
        }
        while (j <= right) {
            helper[index++] = array[j++];
        }
        for (int k = 0; k < helper.length; k++) {
            array[left+k] = helper[k];
        }
    }
}
