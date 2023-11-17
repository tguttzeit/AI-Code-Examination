package Copilot.QuickSort.T30;

public class QuickSort {

    // The sort(int[]) method should sort the array in ascending order.
    public static void sort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
    }

    // The sort(int[]) method should sort the array in ascending order.
    private static void quickSort(int[] array, int low, int high) {
        int i = low;
        int j = high;
        int pivot = array[low + (high - low) / 2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            // Swap the elements
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                // Move index to next position on both sides
                i++;
                j--;
            }
        }

        // Call quickSort() method recursively
        if (low < j) {
            quickSort(array, low, j);
        }

        if (i < high) {
            quickSort(array, i, high);
        }
    }

}
