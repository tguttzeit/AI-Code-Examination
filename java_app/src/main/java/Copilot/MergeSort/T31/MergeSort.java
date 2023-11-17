package Copilot.MergeSort.T31;

public class MergeSort {
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int from, int to) {
        if (from == to) {
            return;
        }

        int mid = (from + to) / 2;
        mergeSort(arr, from, mid);
        mergeSort(arr, mid + 1, to);
        merge(arr, from, mid, to);
    }

    private void merge(int[] arr, int from, int mid, int to) {
        int[] temp = new int[to - from + 1];
        int i = from;
        int j = mid + 1;
        int k = 0;

        while (i <= mid || j <= to) {
            if (i > mid) {
                temp[k++] = arr[j++];
            } else if (j > to) {
                temp[k++] = arr[i++];
            } else if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        for (k = 0; k < temp.length; k++) {
            arr[from + k] = temp[k];
        }
    }
}
