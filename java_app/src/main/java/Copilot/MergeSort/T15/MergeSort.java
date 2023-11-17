package Copilot.MergeSort.T15;

public class MergeSort {
    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) return;
        int mid = (end + start) / 2;
        mergeSort(arr, temp, start, mid);
        mergeSort(arr, temp, mid + 1, end);
        merge(arr, temp, start, mid, end);
    }

    private void merge(int[] arr, int[] temp, int start, int mid, int end) {
        // copy to temp
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        // merge
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) arr[k] = temp[j++];
            else if (j > end) arr[k] = temp[i++];
            else if (temp[i] < temp[j]) arr[k] = temp[i++];
            else arr[k] = temp[j++];
        }
    }
}
