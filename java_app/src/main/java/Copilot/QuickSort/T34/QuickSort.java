package Copilot.QuickSort.T34;

public class QuickSort {
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot);
        quickSort(arr, pivot + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1, j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) return j;
            swap(arr, i, j);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int buffer = arr[a];
        arr[a] = arr[b];
        arr[b] = buffer;
    }
}
