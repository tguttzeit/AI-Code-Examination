package Copilot.MergeSort.T1;

public class MergeSort {
    public void mergeSort(int[] arr) {
        int len = arr.length;
        if (len < 2) return;
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, len - mid);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    private void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;
        int leftLen = left.length, rightLen = right.length;
        while (i < leftLen && j < rightLen) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < leftLen) arr[k++] = left[i++];
        while (j < rightLen) arr[k++] = right[j++];
    }
}
