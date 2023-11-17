class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Choose a pivot element (e.g., the last element)
        pivot = arr.pop()

        # Create two empty lists to hold elements smaller and larger than the pivot
        smaller_elements = []
        larger_elements = []

        # Partition the elements into smaller and larger lists
        for element in arr:
            if element <= pivot:
                smaller_elements.append(element)
            else:
                larger_elements.append(element)

        # Recursively sort the smaller and larger lists
        self.sort(smaller_elements)
        self.sort(larger_elements)

        # Combine the sorted smaller elements, pivot, and sorted larger elements
        arr.extend(smaller_elements)
        arr.append(pivot)
        arr.extend(larger_elements)
