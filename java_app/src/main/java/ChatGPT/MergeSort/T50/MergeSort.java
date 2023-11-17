package ChatGPT.MergeSort.T50;

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
            int middle = (left + right) / 2;
            mergeSort(array, tempArray, left, middle); // Sort left half
            mergeSort(array, tempArray, middle + 1, right); // Sort right half
            merge(array, tempArray, left, middle, right); // Merge the sorted halves
        }
    }

    private void merge(int[] array, int[] tempArray, int left, int middle, int right) {
        // Copy elements to tempArray
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }

        int leftIndex = left;
        int rightIndex = middle + 1;
        int currentIndex = left;

        // Merge back the two halves into the original array
        while (leftIndex <= middle && rightIndex <= right) {
            if (tempArray[leftIndex] <= tempArray[rightIndex]) {
                array[currentIndex] = tempArray[leftIndex];
                leftIndex++;
            } else {
                array[currentIndex] = tempArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }

        // Copy remaining elements from left subarray
        while (leftIndex <= middle) {
            array[currentIndex] = tempArray[leftIndex];
            leftIndex++;
            currentIndex++;
        }

        // Copy remaining elements from right subarray
        while (rightIndex <= right) {
            array[currentIndex] = tempArray[rightIndex];
            rightIndex++;
            currentIndex++;
        }
    }
}
