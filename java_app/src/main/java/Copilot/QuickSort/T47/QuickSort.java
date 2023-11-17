package Copilot.QuickSort.T47;

public class QuickSort {

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = partition(array, l, r);
        quickSort(array, l, pivot - 1);
        quickSort(array, pivot + 1, r);
    }

    private int partition(int[] array, int l, int r) {
        int pivot = array[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, r);
        return i + 1;
    }

    private void swap(int[] array, int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }

}
