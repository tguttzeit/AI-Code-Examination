package Copilot.QuickSort.T4;

public class QuickSort {

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Implement a non-static quick sort algorithm class named QuickSort with a private void quickSort(int[], int, int) method.
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);

            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    // Implement a non-static quick sort algorithm class named QuickSort with a private int partition(int[], int, int) method.
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

    // Implement a non-static quick sort algorithm class named QuickSort with a private void swap(int[], int, int) method.
    private void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];

            array[i] = array[j];
            array[j] = temp;
        }
    }

}
