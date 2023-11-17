package Copilot.MergeSort.T44;

public class MergeSort {
    public void mergeSort(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int j = mid; j < length; j++) {
            right[j - mid] = arr[j];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }
    public void merge(int[] left, int[] right, int[] arr) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++]; 
            }
        }
        while (i < leftLength) {
            arr[k++] = left[i++];
        }
        while (j < rightLength) {
            arr[k++] = right[j++];
        }
    }
}
