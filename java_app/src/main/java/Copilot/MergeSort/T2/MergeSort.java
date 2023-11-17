package Copilot.MergeSort.T2;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private void mergeSortHelper(int[] arr, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }
        // recursive rule
        int mid = left + (right - left) / 2;
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid + 1, right);
        merge(arr, left, right);
    }

    private void merge(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        int[] helper = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                helper[index++] = arr[i++];
            } else {
                helper[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            helper[index++] = arr[i++];
        }
        while (j <= right) {
            helper[index++] = arr[j++];
        }
        for (int k = 0; k < helper.length; k++) {
            arr[left + k] = helper[k];
        }
    }
}
