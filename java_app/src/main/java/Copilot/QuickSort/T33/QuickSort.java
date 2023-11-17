package Copilot.QuickSort.T33;

public class QuickSort {
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = partition(arr, lo, hi);
        quickSort(arr, lo, pivot - 1);
        quickSort(arr, pivot + 1, hi);
    }

    public int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo;
        int j = hi - 1;
        while (i <= j) {
            if (arr[i] <= pivot) i++;
            else if (arr[j] > pivot) j--;
            else swap(arr, i++, j--);
        }
        swap(arr, i, hi);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
