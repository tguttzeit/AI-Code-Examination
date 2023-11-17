package Copilot.MergeSort.T20;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int[] left = new int[arr.length / 2];
            int[] right = new int[arr.length - left.length];

            for (int i = 0; i < arr.length; i++) {
                if (i < left.length) {
                    left[i] = arr[i];
                } else {
                    right[i - left.length] = arr[i];
                }
            }

            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }

    public void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0;

        while (i + j < arr.length) {
            if (j == right.length || (i < left.length && left[i] < right[j])) {
                arr[i + j] = left[i++];
            } else {
                arr[i + j] = right[j++];
            }
        }
    }
}
