class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Choose a pivot element (e.g., the last element)
        pivot = arr[-1]

        # Partition the array into two sub-arrays
        left = []
        right = []
        equal = []

        for num in arr:
            if num < pivot:
                left.append(num)
            elif num > pivot:
                right.append(num)
            else:
                equal.append(num)

        # Recursively sort the sub-arrays
        left = self.sort(left)
        right = self.sort(right)

        # Combine the sorted sub-arrays and pivot element
        sorted_arr = left + equal + right

        # Modify the input array in place
        for i in range(len(arr)):
            arr[i] = sorted_arr[i]