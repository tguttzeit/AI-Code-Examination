class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Select a pivot element (for simplicity, we'll choose the last element)
        pivot = arr[-1]

        # Initialize left and right sublists
        left = []
        right = []

        # Partition the array into left and right sublists
        for item in arr[:-1]:
            if item < pivot:
                left.append(item)
            else:
                right.append(item)

        # Recursively sort the left and right sublists
        left = self.sort(left)
        right = self.sort(right)

        # Combine the sorted left and right sublists with the pivot
        arr[:] = left + [pivot] + right
