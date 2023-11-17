package Copilot.MergeSort.T8;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int[] left = new int[arr.length / 2];
            int[] right = new int[arr.length - arr.length / 2];
            System.arraycopy(arr, 0, left, 0, left.length);
            System.arraycopy(arr, arr.length / 2, right, 0, right.length);
            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }

    private void merge(int[] arr, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                arr[arrIndex] = left[leftIndex];
                leftIndex++;
            } else {
                arr[arrIndex] = right[rightIndex];
                rightIndex++;
            }
            arrIndex++;
        }
        if (leftIndex < left.length) {
            System.arraycopy(left, leftIndex, arr, arrIndex, left.length - leftIndex);
        } else if (rightIndex < right.length) {
            System.arraycopy(right, rightIndex, arr, arrIndex, right.length - rightIndex);
        }
    }
}
