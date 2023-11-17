package Copilot.QuickSort.T21;

public class QuickSort {

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q, r);
        }
    }

    private int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, ++i, r);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
    }

}
