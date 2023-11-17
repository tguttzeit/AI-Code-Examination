class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Choose a pivot element (in this case, the last element)
        pivot = arr[-1]

        # Initialize left and right sublists
        left = []
        right = []

        # Partition the elements into left and right sublists
        for element in arr[:-1]:
            if element <= pivot:
                left.append(element)
            else:
                right.append(element)

        # Recursively sort the left and right sublists
        left = self.sort(left)
        right = self.sort(right)

        # Combine the sorted left sublist, pivot, and sorted right sublist
        return left + [pivot] + right
