package Copilot.QuickSort.T3;

public class QuickSort {

    // Implement the quick sort algorithm in the sort(int[]) method.
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Implement the quick sort algorithm in the quickSort(int[], int, int) method.
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int p = partition(array, low, high);
            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }

    // Implement the quick sort algorithm in the partition(int[], int, int) method.
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, high);
        return i;
    }

    // Implement the quick sort algorithm in the swap(int[], int, int) method.
    private void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
