class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Choose a pivot element (for simplicity, we'll use the last element)
        pivot = arr[-1]

        # Initialize three empty lists to hold elements smaller, equal, and greater than the pivot
        smaller = []
        equal = []
        greater = []

        # Partition the elements into the three lists
        for num in arr:
            if num < pivot:
                smaller.append(num)
            elif num == pivot:
                equal.append(num)
            else:
                greater.append(num)

        # Recursively sort the smaller and greater lists
        smaller_sorted = self.sort(smaller)
        greater_sorted = self.sort(greater)

        # Combine the sorted lists and the equal elements
        arr[:] = smaller_sorted + equal + greater_sorted
