class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Choose a pivot element
        pivot = arr[len(arr) // 2]

        # Partition the list into two sublists
        less_than_pivot = [x for x in arr if x < pivot]
        equal_to_pivot = [x for x in arr if x == pivot]
        greater_than_pivot = [x for x in arr if x > pivot]

        # Recursively sort the sublists
        self.sort(less_than_pivot)
        self.sort(greater_than_pivot)

        # Combine the sorted sublists and pivot
        arr[:] = less_than_pivot + equal_to_pivot + greater_than_pivot
