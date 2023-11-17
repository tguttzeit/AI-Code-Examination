package Copilot.QuickSort.T36;

public class QuickSort {

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        int temp;

        while (i < j) {
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] > pivot && j > low) {
                j--;
            }

            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void quickSort(int[] arr, int low, int high) {
        int j;

        if (low < high) {
            j = partition(arr, low, high);
            quickSort(arr, low, j - 1);
            quickSort(arr, j + 1, high);
        }
    }

    public static void sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        quickSort(arr, low, high);
    }
}
