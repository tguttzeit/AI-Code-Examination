package ChatGPT.MergeSort.T24;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, temp, left, middle);
            mergeSort(arr, temp, middle + 1, right);
            merge(arr, temp, left, middle, right);
        }
    }

    private void merge(int[] arr, int[] temp, int left, int middle, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}
