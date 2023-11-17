package Copilot.MergeSort.T5;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (end - start) / 2 + start;
        mergeSort(arr, temp, start, middle);
        mergeSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, end);
    }

    private void merge(int[] arr, int[] temp, int start, int middle, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int left = start;
        int right = middle + 1;
        int index = start;

        while (left <= middle && right <= end) {
            if (temp[left] <= temp[right]) {
                arr[index] = temp[left];
                left++;
            } else {
                arr[index] = temp[right];
                right++;
            }

            index++;
        }

        while (left <= middle) {
            arr[index] = temp[left];
            left++;
            index++;
        }
    }
}
