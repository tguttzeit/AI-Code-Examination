class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Choose a pivot element
        pivot = arr[len(arr) // 2]

        # Partition the list into two sublists - elements smaller and larger than the pivot
        left = [x for x in arr if x < pivot]
        middle = [x for x in arr if x == pivot]
        right = [x for x in arr if x > pivot]

        # Recursively sort the sublists
        left = self.sort(left)
        right = self.sort(right)

        # Combine the sorted sublists and the pivot back into a single list
        arr = left + middle + right

        return arr
