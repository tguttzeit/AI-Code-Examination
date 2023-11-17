package Copilot.MergeSort.T3;

public class MergeSort {
    public void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	
	private void mergeSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		
		int middle = (left + right) / 2;
		mergeSort(array, left, middle);
		mergeSort(array, middle + 1, right);
		merge(array, left, middle, right);
	}
	
	private void merge(int[] array, int left, int middle, int right) {
		int[] leftArray = new int[middle - left + 1];
		int[] rightArray = new int[right - middle];
		
		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = array[left + i];
		}
		
		for (int i = 0; i < rightArray.length; i++) {
			rightArray[i] = array[middle + 1 + i];
		}
		
		int leftIndex = 0;
		int rightIndex = 0;
		
		for (int i = left; i < right + 1; i++) {
			if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
				if (leftArray[leftIndex] < rightArray[rightIndex]) {
					array[i] = leftArray[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
			} else if (leftIndex < leftArray.length) {
				array[i] = leftArray[leftIndex];
				leftIndex++;
			} else if (rightIndex < rightArray.length) {
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}
}
