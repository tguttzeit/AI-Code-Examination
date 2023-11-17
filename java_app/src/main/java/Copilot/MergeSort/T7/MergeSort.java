package Copilot.MergeSort.T7;

public class MergeSort {
    public void mergeSort(int[] array) {
        if (array == null || array.length == 0) return;
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] helper = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right) {
            if (array[i] < array[j]) {
                helper[k++] = array[i++];
            } else {
                helper[k++] = array[j++];
            }
        }
        while(i <= mid) {
            helper[k++] = array[i++];
        }
        while(j <= right) {
            helper[k++] = array[j++];
        }
        for (int p = 0; p < helper.length; p++) {
            array[left + p] = helper[p];
        }
    }
}
