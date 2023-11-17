package ChatGPT.MergeSort.T26;

public class MergeSort {

    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        int n = array.length;
        int[] temp = new int[n];
        mergeSort(array, temp, 0, n - 1);
    }

    private void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(array, temp, left, middle);
            mergeSort(array, temp, middle + 1, right);
            merge(array, temp, left, middle, right);
        }
    }

    private void merge(int[] array, int[] temp, int left, int middle, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        
        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = temp[i];
            i++;
            k++;
        }
    }
}
