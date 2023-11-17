package Copilot.QuickSort.AIGenerated.T10;

public class QuickSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int first, int last) {
        if (first < last) {
            int pivot = partition(arr, first, last);
            sort(arr, first, pivot - 1);
            sort(arr, pivot + 1, last);
        }
    }

    private int partition(int[] arr, int first, int last) {
        int pivot = arr[last];
        int i = first - 1;

        for (int j = first; j < last; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        if (arr[last] < arr[i + 1]) {
            swap(arr, i + 1, last);
        }

        return i + 1;
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
