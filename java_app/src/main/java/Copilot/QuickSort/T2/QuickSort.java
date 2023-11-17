package Copilot.QuickSort.T2;

public class QuickSort {

    // Implement a non-static quick sort algorithm class named QuickSort with a public void sort(int[]) method.
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Implement a non-static quick sort algorithm class named QuickSort with a public void sort(int[]) method.
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex, high);
        }
    }

    // Implement a non-static quick sort algorithm class named QuickSort with a public void sort(int[]) method.
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j <= high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        return i;
    }

    // Implement a non-static quick sort algorithm class named QuickSort with a public void sort(int[]) method.
    private void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

}
