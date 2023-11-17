package Copilot.QuickSort.T11;

public class QuickSort {

    // The sort method must sort the array in ascending order.
    public void sort(int[] array) {
        // The sort method must use the quick sort algorithm.
        quickSort(array, 0, array.length - 1);
    }

    // The sort method must use the quick sort algorithm.
    private void quickSort(int[] array, int low, int high) {
        // The sort method must use the quick sort algorithm.
        if (low < high) {
            // The sort method must use the quick sort algorithm.
            int pi = partition(array, low, high);

            // The sort method must use the quick sort algorithm.
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // The sort method must use the quick sort algorithm.
    private int partition(int[] array, int low, int high) {
        // The sort method must use the quick sort algorithm.
        int pivot = array[high];
        int i = (low - 1);

        // The sort method must use the quick sort algorithm.
        for (int j = low; j < high; j++) {
            // The sort method must use the quick sort algorithm.
            if (array[j] < pivot) {
                // The sort method must use the quick sort algorithm.
                i++;

                // The sort method must use the quick sort algorithm.
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // The sort method must use the quick sort algorithm.
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // The sort method must use the quick sort algorithm.
        return i + 1;
    }

}
