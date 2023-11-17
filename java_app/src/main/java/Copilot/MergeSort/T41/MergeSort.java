package Copilot.MergeSort.T41;

public class MergeSort {

    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, temp, 0, arr.length - 1);
    }

    private void mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (right - left) / 2 + left;
        mergeSortHelper(arr, temp, left, mid);
        mergeSortHelper(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy to temp array.
        for (int i = left; i <= right; ++i) {
            temp[i] = arr[i];
        }

        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (temp[leftIndex] < temp[rightIndex]) {
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
