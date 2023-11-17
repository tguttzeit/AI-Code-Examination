class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Choose a pivot element
        pivot = arr[len(arr) // 2]

        # Partition the list into two sublists
        less_than_pivot = []
        equal_to_pivot = []
        greater_than_pivot = []

        for element in arr:
            if element < pivot:
                less_than_pivot.append(element)
            elif element == pivot:
                equal_to_pivot.append(element)
            else:
                greater_than_pivot.append(element)

        # Recursively sort the sublists
        self.sort(less_than_pivot)
        self.sort(greater_than_pivot)

        # Combine the sorted sublists and pivot to get the final sorted list
        arr[:] = less_than_pivot + equal_to_pivot + greater_than_pivot
