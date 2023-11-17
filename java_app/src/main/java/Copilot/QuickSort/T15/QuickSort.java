package Copilot.QuickSort.T15;

public class QuickSort {

    // The sort method should sort the array in ascending order.
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // The sort method should sort the array in ascending order.
    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(array, start, end);
            quickSort(array, start, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    // The sort method should sort the array in ascending order.
    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int partitionIndex = start;

        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, partitionIndex, end);
        return partitionIndex;
    }

    // The sort method should sort the array in ascending order.
    private void swap(int[] array, int firstIndex, int secondIndex) {
        int firstValue = array[firstIndex];
        int secondValue = array[secondIndex];
        array[firstIndex] = secondValue;
        array[secondIndex] = firstValue;
    }

}
