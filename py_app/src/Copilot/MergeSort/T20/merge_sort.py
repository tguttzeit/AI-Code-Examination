class MergeSort:
    def merge_sort(self, lst):
        if len(lst) <= 1:
            return lst

        mid = len(lst) // 2
        left = lst[:mid]
        right = lst[mid:]

        left = self.merge_sort(left)
        right = self.merge_sort(right)
        return list(self.merge(left, right))

    def merge(self, left, right):
        if not len(left):
            return left

        if not len(right):
            return right

        result = []
        left_index = 0
        right_index = 0
        total_len = len(left) + len(right)
        while len(result) < total_len:
            if left[left_index] < right[right_index]:
                result.append(left[left_index])
                left_index += 1
            else:
                result.append(right[right_index])
                right_index += 1

            if left_index == len(left) or right_index == len(right):
                result.extend(left[left_index:] or right[right_index:])
                break

        return result
