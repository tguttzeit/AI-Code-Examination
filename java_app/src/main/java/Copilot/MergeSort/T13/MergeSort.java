package Copilot.MergeSort.T13;

public class MergeSort {
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    private void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (end - start) / 2 + start;
        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }
    private void merge(int[] arr, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int leftIndex = start;
        int rightIndex = middle + 1;
        int index = 0;
        while (leftIndex <= middle && rightIndex <= end) {
            temp[index++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        while (leftIndex <= middle) {
            temp[index++] = arr[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = arr[rightIndex++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }
    }
}
