package Copilot.QuickSort.T28;

public class QuickSort {

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Implement a static quick sort algorithm with the following signature:
    // private static void quickSort(int[], int, int)
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // partition the array around the pivot value and return the pivot value
            int pivot = partition(array, low, high);
            // recursively sort the sub-arrays
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    // Implement a static partition algorithm with the following signature:
    // private static int partition(int[], int, int)
    private static int partition(int[] array, int low, int high) {
        // choose the pivot value
        int pivot = array[high];
        // create two pointers to keep track of the low and high ends of the array
        int i = low - 1;
        // iterate through the array
        for (int j = low; j < high; j++) {
            // if the current value is less than the pivot value
            if (array[j] < pivot) {
                // increment the low pointer
                i++;
                // swap the low pointer value with the current value
                swap(array, i, j);
            }
        }
        // swap the pivot value with the low pointer value
        swap(array, i + 1, high);
        // return the pivot value
        return i + 1;
    }

    // Implement a static swap algorithm with the following signature:
    // private static void swap(int[], int, int)
    private static void swap(int[] array, int i, int j) {
        // store the value at the low pointer
        int temp = array[i];
        // set the value at the low pointer to the value at the high pointer
        array[i] = array[j];
        // set the value at the high pointer to the stored value
        array[j] = temp;
    }

}
