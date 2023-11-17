class MergeSort:
    def merge_sort(self, list):
        if len(list) <= 1:
            return list

        middle = len(list) // 2
        left = self.merge_sort(list[:middle])
        right = self.merge_sort(list[middle:])
        return self.merge(left, right)

    def merge(self, left, right):
        result = []
        left_idx, right_idx = 0, 0
        while left_idx < len(left) and right_idx < len(right):
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
