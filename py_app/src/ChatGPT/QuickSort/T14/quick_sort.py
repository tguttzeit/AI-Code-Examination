class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Choose a pivot element
        pivot = arr[len(arr) // 2]

        # Partition the array into two sub-arrays
        left = [x for x in arr if x < pivot]
        middle = [x for x in arr if x == pivot]
        right = [x for x in arr if x > pivot]

        # Recursively sort the sub-arrays
        self.sort(left)
        self.sort(right)

        # Combine the sorted sub-arrays and the pivot back into the original array
        arr[:] = left + middle + right
