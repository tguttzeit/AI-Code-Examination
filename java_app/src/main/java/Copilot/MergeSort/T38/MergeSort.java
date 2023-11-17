package Copilot.MergeSort.T38;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
    }

    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        // Divide
        int mid = left + (right - left) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid+1, right);
        // Conquer
        merge(arr, temp, left, mid, right);
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy arr to temp
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        // Merge
        int leftIndex = left;
        int rightIndex = mid+1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (temp[leftIndex] <= temp[rightIndex]) {
                arr[left++] = temp[leftIndex++];
            } else {
                arr[left++] = temp[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            arr[left++] = temp[leftIndex++];
        }
    }
}
