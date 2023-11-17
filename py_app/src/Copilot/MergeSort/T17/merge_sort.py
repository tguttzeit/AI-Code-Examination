class MergeSort:
    def __init__(self):
        pass

    def merge_sort(self, arr):
        if len(arr) <= 1:
            return arr
        mid = len(arr) // 2
        left = self.merge_sort(arr[:mid])
        right = self.merge_sort(arr[mid:])
        return self.merge(left, right)

    def merge(self, left, right):
        result = []
        left_idx = right_idx = 0
        while left_idx < len(left) and right_idx < len(right):
            # change the direction of this comparison to change the direction of the sort
            if left[left_idx] <= right[right_idx]:
                result.append(left[left_idx])
                left_idx += 1
            else:
                result.append(right[right_idx])
                right_idx += 1

        if left:
            result.extend(left[left_idx:])
        if right:
            result.extend(right[right_idx:])
        return result
