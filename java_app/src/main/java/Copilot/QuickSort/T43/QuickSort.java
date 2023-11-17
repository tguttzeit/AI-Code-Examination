package Copilot.QuickSort.T43;

public class QuickSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; ++i) {
            if (arr[i] < pivot) {
                swap(arr, i, j + 1);
                ++j;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
