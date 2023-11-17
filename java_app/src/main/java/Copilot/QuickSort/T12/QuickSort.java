package Copilot.QuickSort.T12;

public class QuickSort {

    // Your sort(int[]) method should take an array of integers as input and sort the array in ascending order.
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Your sort(int[]) method should use the quick sort algorithm to sort the array.
    // Your sort(int[]) method should be recursive.
    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(array, start, end);
            quickSort(array, start, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    // Your sort(int[]) method should use the first element in the array as the pivot.
    private int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (array[i] <= pivot && i < end) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, start, j);
        return j;
    }

    // Your sort(int[]) method should swap elements in the array.
    private void swap(int[] array, int i, int j) {
        int temp = array[i]; // temp = 5
        array[i] = array[j]; // array[i] = 2
        array[j] = temp; // array[j] = 5
    }

}
