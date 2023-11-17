package Copilot.QuickSort.T31;

// Implement a non-static quick sort algorithm class named QuickSort with a public void sort(int[]) method.
public class QuickSort {


    // The method should sort the array in ascending order.
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // The method should sort the array in ascending order.
    public void quickSort(int[] array, int low, int high) {
        int i = low;
        int j = high;
        int pivot = array[low + (high - low) / 2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (pivot < array[j]) {
                j--;
            }

            if (i <= j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;

                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(array, low, j);
        }

        if (i < high) {
            quickSort(array, i, high);
        }
    }

}
