class MergeSort:

    def merge_sort(self, arr):
        if len(arr) > 1:
            mid = len(arr) // 2  # Finding the mid of the array
            left = arr[:mid]  # Dividing the array elements
            right = arr[mid:]  # into 2 halves

            self.merge_sort(left)  # Sorting the first half
            self.merge_sort(right)  # Sorting the second half

            i = j = k = 0

            # Copy data to temp arrays left[] and right[]
            while i < len(left) and j < len(right):
                if left[i] < right[j]:
                    arr[k] = left[i]
                    i += 1
                else:
                    arr[k] = right[j]
                    j += 1
                k += 1

            # Checking if any element was left
            while i < len(left):
                arr[k] = left[i]
                i += 1
                k += 1

            while j < len(right):
                arr[k] = right[j]
                j += 1
                k += 1

        return arr
