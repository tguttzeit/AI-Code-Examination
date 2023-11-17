package Copilot.QuickSort.T32;

public class QuickSort {

    // Implement the quick sort algorithm using the provided pseudo-code.
    public void sort(int[] array) {
        // Use the first element of the array as the pivot.
        // Partition the array into two parts:
        // 1. All elements smaller than the pivot.
        // 2. All elements larger than the pivot.
        // Recursively sort the first and second parts.
        // The base case is reached when the array has 0 or 1 elements.
        if (array.length > 1) {
            int pivot = array[0];
            int[] smaller = new int[array.length];
            int[] larger = new int[array.length];
            int smallerCount = 0;
            int largerCount = 0;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < pivot) {
                    smaller[smallerCount] = array[i];
                    smallerCount++;
                } else {
                    larger[largerCount] = array[i];
                    largerCount++;
                }
            }
            int[] smallerArray = new int[smallerCount];
            int[] largerArray = new int[largerCount];
            for (int i = 0; i < smallerCount; i++) {
                smallerArray[i] = smaller[i];
            }
            for (int i = 0; i < largerCount; i++) {
                largerArray[i] = larger[i];
            }
            sort(smallerArray);
            sort(largerArray);
            for (int i = 0; i < smallerCount; i++) {
                array[i] = smallerArray[i];
            }
            array[smallerCount] = pivot;
            for (int i = 0; i < largerCount; i++) {
                array[smallerCount + 1 + i] = largerArray[i];
            }
        }
    }

}
