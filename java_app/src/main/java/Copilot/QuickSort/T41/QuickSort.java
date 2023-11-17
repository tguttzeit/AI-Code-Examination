package Copilot.QuickSort.T41;

// Implement a non-static quick sort algorithm class named QuickSort with a public void sort(int[]) method.
public class QuickSort {

    // Implement a non-static quick sort algorithm class named QuickSort with a public void sort(int[]) method.
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // quickSort method
    private void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot);
        quickSort(array, pivot + 1, right);
    }

    // partition method
    private int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do {
                i++;
            } while (array[i] < pivot);
            do {
                j--;
            } while (array[j] > pivot);
            if (i >= j) return j;
            swap(array, i, j);
        }
    }

    // swap method
    private void swap(int[] array, int i, int j) {
        if (i == j) return;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
