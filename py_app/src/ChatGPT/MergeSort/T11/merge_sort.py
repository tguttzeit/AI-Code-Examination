class MergeSort:
    def merge_sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Split the array into two halves
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_half = arr[mid:]

        # Recursively sort each half
        left_half = self.merge_sort(left_half)
        right_half = self.merge_sort(right_half)

        # Merge the sorted halves
        sorted_arr = self.merge(left_half, right_half)
        return sorted_arr

    def merge(self, left, right):
        result = []
        left_idx, right_idx = 0, 0

        # Compare elements from left and right sub-arrays and merge them in sorted order
        while left_idx < len(left) and right_idx < len(right):
            if left[left_idx] < right[right_idx]:
                result.append(left[left_idx])
                left_idx += 1
            else:
                result.append(right[right_idx])
                right_idx += 1

        # Append remaining elements from both arrays (if any)
        result.extend(left[left_idx:])
        result.extend(right[right_idx:])

        return result
