package Copilot.QuickSort.T26;

public class QuickSort {

    public void sort(int[] arr) {
        // Call the static method sort() from the QuickSort class.
        QuickSort.sort(arr, 0, arr.length - 1);
    }

    // Implement a static method named sort(int[], int, int) that sorts the given array
    // from the given left index to the given right index.
    public static void sort(int[] arr, int left, int right) {
        // If the left index is greater than or equal to the right index, return.
        if (left >= right) {
            return;
        }

        // Call the static method partition() from the QuickSort class.
        int pivot = QuickSort.partition(arr, left, right);

        // Call the static method sort() from the QuickSort class.
        QuickSort.sort(arr, left, pivot - 1);
        QuickSort.sort(arr, pivot + 1, right);
    }

    // Implement a static method named partition(int[], int, int) that partitions the given array
    // from the given left index to the given right index and returns the pivot index.
    public static int partition(int[] arr, int left, int right) {
        // Initialize the pivot index to the left index.
        int pivot = left;

        // Iterate from the left index plus one to the right index.
        for (int i = left + 1; i <= right; i++) {
            // If the element at the current index is less than the element at the left index,
            // increment the pivot index and swap the elements at the pivot index and the current index.
            if (arr[i] < arr[left]) {
                pivot++;
                int temp = arr[pivot];
                arr[pivot] = arr[i];
                arr[i] = temp;
            }
        }

        // Swap the elements at the left index and the pivot index.
        int temp = arr[left];
        arr[left] = arr[pivot];
        arr[pivot] = temp;

        // Return the pivot index.
        return pivot;
    }

}
