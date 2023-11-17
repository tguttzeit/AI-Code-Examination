package Copilot.QuickSort.T40;

public class QuickSort {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);

            // Recursively sort elements before and after partition
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, end);

        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];

        arr[j] = arr[i];
        arr[i] = temp;
    }

}
