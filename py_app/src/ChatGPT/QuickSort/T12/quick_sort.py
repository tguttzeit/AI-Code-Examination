class QuickSort:
    def sort(self, arr):
        if not arr:
            return arr
        self._quick_sort(arr, 0, len(arr) - 1)

    def _quick_sort(self, arr, low, high):
        if low < high:
            # Partition the array, arr[pivot] is now at the correct position
            pivot_index = self._partition(arr, low, high)

            # Recursively sort the two sub-arrays
            self._quick_sort(arr, low, pivot_index - 1)
            self._quick_sort(arr, pivot_index + 1, high)

    def _partition(self, arr, low, high):
        pivot = arr[high]  # Choose the last element as the pivot
        i = low - 1  # Index of the smaller element

        for j in range(low, high):
            if arr[j] < pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]  # Swap arr[i] and arr[j]

        arr[i + 1], arr[high] = arr[high], arr[i + 1]  # Swap arr[i+1] and arr[high] (pivot)
        return i + 1
