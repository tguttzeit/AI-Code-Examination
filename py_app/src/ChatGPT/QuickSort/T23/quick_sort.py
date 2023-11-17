class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Choose a pivot element (e.g., the last element in the list)
        pivot = arr[-1]

        # Create two lists to hold elements less than and greater than the pivot
        less_than_pivot = []
        greater_than_pivot = []

        # Partition the array into two sub-arrays based on the pivot
        for element in arr[:-1]:
            if element <= pivot:
                less_than_pivot.append(element)
            else:
                greater_than_pivot.append(element)

        # Recursively sort the sub-arrays
        self.sort(less_than_pivot)
        self.sort(greater_than_pivot)

        # Combine the sorted sub-arrays and pivot to get the final sorted array
        arr[:] = less_than_pivot + [pivot] + greater_than_pivot
