package ChatGPT.QuickSort.T18;

public class QuickSort {
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Base case: already sorted or empty array
        }

        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1); // Sort elements before the pivot
            quickSort(array, pivotIndex + 1, high); // Sort elements after the pivot
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choose the last element as the pivot
        int i = low - 1; // Index of the smaller element

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high); // Place pivot in the correct position
        return i + 1; // Return the index of pivot
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
