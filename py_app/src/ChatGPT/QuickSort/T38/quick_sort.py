class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Choose a pivot element
        pivot = arr[len(arr) // 2]

        # Partition the list into two sublists
        left = [x for x in arr if x < pivot]
        middle = [x for x in arr if x == pivot]
        right = [x for x in arr if x > pivot]

        # Recursively sort the sublists
        self.sort(left)
        self.sort(right)

        # Combine the sorted sublists and pivot back together
        arr[:] = left + middle + right
