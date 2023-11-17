class MergeSort:
    def merge_sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Split the array into two halves
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_half = arr[mid:]

        # Recursively sort both halves
        left_half = self.merge_sort(left_half)
        right_half = self.merge_sort(right_half)

        # Merge the sorted halves
        sorted_arr = self.merge(left_half, right_half)
        return sorted_arr

    def merge(self, left, right):
        result = []
        i = j = 0

        # Merge the two sorted arrays into a single sorted array
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                result.append(left[i])
                i += 1
            else:
                result.append(right[j])
                j += 1

        # Append the remaining elements from both arrays (if any)
        result.extend(left[i:])
        result.extend(right[j:])
        return result
