class MergeSort:
    def merge_sort(self, arr):
        if len(arr) <= 1:
            return arr

        # Split the input list into two halves
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_half = arr[mid:]

        # Recursively apply merge_sort to both halves
        left_half = self.merge_sort(left_half)
        right_half = self.merge_sort(right_half)

        # Merge the sorted halves
        return self.merge(left_half, right_half)

    def merge(self, left, right):
        merged = []
        left_idx, right_idx = 0, 0

        while left_idx < len(left) and right_idx < len(right):
            if left[left_idx] < right[right_idx]:
                merged.append(left[left_idx])
                left_idx += 1
            else:
                merged.append(right[right_idx])
                right_idx += 1

        # Append any remaining elements from left and right sublists
        merged.extend(left[left_idx:])
        merged.extend(right[right_idx:])

        return merged
