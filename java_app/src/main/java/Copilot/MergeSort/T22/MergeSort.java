package Copilot.MergeSort.T22;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }
    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >>> 1);
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }
    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int index = left;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[index++] = arr[leftIndex++];
            } else {
                temp[index++] = arr[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            temp[index++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[index++] = arr[rightIndex++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
