package Copilot.QuickSort.T8;

public class QuickSort {

    public void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        quickSort(array, 0, array.length - 1);
    }

    // Implement a recursive private void quickSort(int[], int, int) method.
    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    // Implement a private int partition(int[], int, int) method.
    private int partition(int[] array, int left, int right) {
        int pivotIndex = left + (right - left) / 2;
        int pivotValue = array[pivotIndex];
        int i = left;
        int j = right;
        while (i <= j) {
            while (array[i] < pivotValue) {
                i++;
            }
            while (array[j] > pivotValue) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    // Implement a private void swap(int[], int, int) method.
    private void swap(int[] array, int i, int j) {
        int tempValue = array[i];
        array[i] = array[j];
        array[j] = tempValue;
    }

}
