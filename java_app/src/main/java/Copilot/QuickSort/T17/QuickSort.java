package Copilot.QuickSort.T17;

public class QuickSort {

    // The sort method should sort the input array in ascending order.
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Use the first element in the array as the pivot.
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    // Return the index of the pivot after the partition.
    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            if (array[j] < pivot) {
                swap(array, j, i);
                i++;
            }
        }
        swap(array, low, i - 1);
        return i - 1;
    }

    // Swap the elements at index i and j.
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
