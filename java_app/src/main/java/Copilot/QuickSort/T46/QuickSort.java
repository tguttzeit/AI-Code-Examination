package Copilot.QuickSort.T46;

public class QuickSort {

    // The method must sort the array in place.
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // The method must be recursive.
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int split = partition(arr, low, high);
            quickSort(arr, low, split - 1);
            quickSort(arr, split + 1, high);
        }
    }

    // The method must implement the Hoare partitioning scheme.
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;
        while (i <= j) {
            while (i <= j && arr[i] <= pivot) i++;
            while (i <= j && arr[j] >= pivot) j--;
            if (i < j) swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    // The method must swap two elements in the array.
    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;

    }

}
