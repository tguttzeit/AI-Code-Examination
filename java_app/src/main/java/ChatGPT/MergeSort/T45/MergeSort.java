package ChatGPT.MergeSort.T45;

public class MergeSort {

    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // No need to sort
        }

        int[] tempArray = new int[array.length];
        mergeSort(array, tempArray, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(array, tempArray, left, mid); // Sort left half
            mergeSort(array, tempArray, mid + 1, right); // Sort right half
            
            merge(array, tempArray, left, mid, right); // Merge the sorted halves
        }
    }

    private void merge(int[] array, int[] tempArray, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            array[k] = tempArray[i];
            i++;
            k++;
        }

        // No need to handle the remaining elements in the right half,
        // because they are already in their correct positions in tempArray.
    }
}

