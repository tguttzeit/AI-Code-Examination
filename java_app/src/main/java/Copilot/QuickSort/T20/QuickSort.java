package Copilot.QuickSort.T20;

public class QuickSort {

    // The sort(int[]) method should sort the array in place using the quick sort algorithm.
    public static void sort(int[] array) {
        // Check if array is null
        if (array == null) {
            return;
        }

        // Check if array is empty
        if (array.length == 0) {
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    // The quickSort(int[], int, int) method should sort the array in place using the quick sort algorithm.
    private static void quickSort(int[] array, int left, int right) {
        // Check if array is null
        if (array == null) {
            return;
        }

        // Check if array is empty
        if (array.length == 0) {
            return;
        }

        // Check if left is greater than or equal to right
        if (left >= right) {
            return;
        }

        // Find pivot
        int pivot = array[left + (right - left) / 2];

        // Partition
        int i = left;
        int j = right;

        while (i <= j) {
            // Find element on left that should be on right
            while (array[i] < pivot) {
                i++;
            }

            // Find element on right that should be on left
            while (array[j] > pivot) {
                j--;
            }

            // Swap elements and move left and right indices
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        // Recursively sort two sub parts
        if (left < j) {
            quickSort(array, left, j);
        }

        if (i < right) {
            quickSort(array, i, right);
        }
    }

    // The swap(int[], int, int) method should swap the elements at the given indices in the given array.
    private static void swap(int[] array, int i, int j) {
        // Check if array is null
        if (array == null) {
            return;
        }

        // Check if array is empty
        if (array.length == 0) {
            return;
        }

        // Swap elements
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
