package Copilot.MergeSort.T47;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }
    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // divide
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        // merge
        merge(arr, left, mid, right);
    }
    public void merge(int[] arr, int left, int mid, int right) {
        int[] helper = new int[arr.length];
        for (int i = left; i <= right; i++) {
            helper[i] = arr[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                arr[left++] = helper[leftIndex++];
            } else {
                arr[left++] = helper[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            arr[left++] = helper[leftIndex++];
        }
    }
}