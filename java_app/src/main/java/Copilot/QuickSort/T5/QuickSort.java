package Copilot.QuickSort.T5;

// Implement a non-static quick sort algorithm class named QuickSort with a public void sort(int[]) method.
public class QuickSort {

    // Implement the quick sort algorithm in the sort method.
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Implement the quick sort algorithm in the quickSort method.
    private void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    // Implement the partition algorithm in the partition method.
    private int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[endIndex];
        int i = startIndex - 1;
        for (int j = startIndex; j < endIndex; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[endIndex];
        array[endIndex] = temp;
        return i + 1;
    }

}
