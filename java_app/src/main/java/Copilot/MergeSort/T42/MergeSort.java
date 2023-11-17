package Copilot.MergeSort.T42;

public class MergeSort {
    public void mergeSort(int[] data) {
        if (data.length < 2) return;
        int mid = data.length / 2;
        int[] left = new int[mid];
        int[] right = new int[data.length - mid];
        for (int i = 0; i < mid; i++) left[i] = data[i];
        for (int i = mid; i < data.length; i++) right[i - mid] = data[i];
        mergeSort(left);
        mergeSort(right);
        merge(data, left, right);
    }

    private void merge(int[] data, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
            data[k++] = left[i] < right[j] ? left[i++] : right[j++];
        while (i < left.length) data[k++] = left[i++];
        while (j < right.length) data[k++] = right[j++];
    }
}
