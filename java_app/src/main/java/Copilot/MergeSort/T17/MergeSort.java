package Copilot.MergeSort.T17;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[arr.length - mid];
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            rightHalf[i - mid] = arr[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(arr, leftHalf, rightHalf);
    }

    private void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
        int i = 0, j = 0, k = 0;
        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {
                arr[k++] = leftHalf[i++];
            } else {
                arr[k++] = rightHalf[j++];
            }
        }
        while (i < leftHalf.length) {
            arr[k++] = leftHalf[i++];
        }
        while (j < rightHalf.length) {
            arr[k++] = rightHalf[j++];
        }
    }
}
