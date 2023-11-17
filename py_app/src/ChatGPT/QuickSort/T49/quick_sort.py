class QuickSort:
    def sort(self, arr):
        if not arr:
            return

        self._quick_sort(arr, 0, len(arr) - 1)

    def _quick_sort(self, arr, low, high):
        if low < high:
            # Partition the array, arr[pivot] is now in its correct position
            pivot_index = self._partition(arr, low, high)

            # Recursively sort the subarrays on both sides of the pivot
            self._quick_sort(arr, low, pivot_index - 1)
            self._quick_sort(arr, pivot_index + 1, high)

    def _partition(self, arr, low, high):
        pivot = arr[high]  # Choose the pivot element (last element)
        i = low - 1  # Initialize the index of the smaller element

        for j in range(low, high):
            # If the current element is smaller than or equal to the pivot
            if arr[j] <= pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]  # Swap elements at i and j

        # Place the pivot element in its correct position
        arr[i + 1], arr[high] = arr[high], arr[i + 1]
        return i + 1
