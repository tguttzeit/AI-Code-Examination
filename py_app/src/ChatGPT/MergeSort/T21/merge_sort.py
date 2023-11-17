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
        return self.merge(left_half, right_half)

    def merge(self, left, right):
        merged = []
        left_index, right_index = 0, 0

        # Merge the two halves while maintaining sorted order
        while left_index < len(left) and right_index < len(right):
            if left[left_index] < right[right_index]:
                merged.append(left[left_index])
                left_index += 1
            else:
                merged.append(right[right_index])
                right_index += 1

        # Append any remaining elements (if any) from both lists
        merged.extend(left[left_index:])
        merged.extend(right[right_index:])

        return merged
