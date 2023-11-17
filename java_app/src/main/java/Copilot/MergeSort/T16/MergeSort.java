package Copilot.MergeSort.T16;

public class MergeSort {
    public void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }
    private void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, mid, right);
        }
    }
    private void merge(int[] arr, int[] tmp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tmp[i] = arr[i];
        }
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            arr[k++] = tmp[i] < tmp[j] ? tmp[i++] : tmp[j++];
        }
        while (i <= mid) {
            arr[k++] = tmp[i++];
        }
    }
}
