package Copilot.MergeSort.T6;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left)/2;

        mergeSort(arr, helper, left, mid);
        mergeSort(arr, helper, mid + 1, right);
        merge(arr, helper, left, mid, right);
    }

    private void merge(int[] arr, int[] helper, int left, int mid, int right) {
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
