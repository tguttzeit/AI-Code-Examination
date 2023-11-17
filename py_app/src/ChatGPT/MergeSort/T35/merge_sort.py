class MergeSort:
    def merge_sort(self, arr):
        if len(arr) > 1:
            mid = len(arr) // 2  # Find the middle of the list
            left_half = arr[:mid]  # Split the list into two halves
            right_half = arr[mid:]

            # Recursive calls to merge_sort() for both halves
            self.merge_sort(left_half)
            self.merge_sort(right_half)

            i = j = k = 0

            # Merge the two halves back together
            while i < len(left_half) and j < len(right_half):
                if left_half[i] < right_half[j]:
                    arr[k] = left_half[i]
                    i += 1
                else:
                    arr[k] = right_half[j]
                    j += 1
                k += 1

            # Check if any element was left
            while i < len(left_half):
                arr[k] = left_half[i]
                i += 1
                k += 1

            while j < len(right_half):
                arr[k] = right_half[j]
                j += 1
                k += 1

        return arr
