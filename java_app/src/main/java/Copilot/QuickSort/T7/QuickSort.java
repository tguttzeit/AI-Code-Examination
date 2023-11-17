package Copilot.QuickSort.T7;

public class QuickSort {

    // The sort(int[]) method should sort the array in ascending order.
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    // The sort(int[]) method should sort the array in ascending order.
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    // The sort(int[]) method should sort the array in ascending order.
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = i; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    // The sort(int[]) method should sort the array in ascending order.
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
