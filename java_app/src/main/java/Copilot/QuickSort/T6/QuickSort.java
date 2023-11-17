package Copilot.QuickSort.T6;


public class QuickSort {

    // The sort(int[]) method should sort the given array in ascending order.
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Quicksort method
    private void quickSort(int[] array, int low, int high) {
        int pivot = array[low + (high - low) / 2];
        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (pivot < array[j]) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                i++;
                j--;
            }
            if (low < j) {
                quickSort(array, low, j);
            }
            if (i < high) {
                quickSort(array, i, high);
            }
        }
    }


}
