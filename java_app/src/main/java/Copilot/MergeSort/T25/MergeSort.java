package Copilot.MergeSort.T25;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - left.length];
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, left.length, right, 0, right.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < result.length) {
            if (j < left.length && k < right.length) {
                if (left[j] < right[k]) {
                    result[i++] = left[j++];
                } else {
                    result[i++] = right[k++];
                }
            } else if (j < left.length) {
                result[i++] = left[j++];
            } else {
                result[i++] = right[k++];
            }
        }
    }
}
