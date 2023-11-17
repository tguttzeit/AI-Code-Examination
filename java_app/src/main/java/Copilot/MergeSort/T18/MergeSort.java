package Copilot.MergeSort.T18;

public class MergeSort {
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private void mergeSort(int[] arr, int low, int high) {
        if (low + 1 >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid, high);

        int[] temp = new int[high - low];
        int i = low;
        int j = mid;
        int k = 0;
        while (i < mid || j < high) {
            if (i < mid && (j >= high || arr[i] <= arr[j])) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        for (int p = 0; p < temp.length; p++) {
            arr[low + p] = temp[p];
        }
    }
}
