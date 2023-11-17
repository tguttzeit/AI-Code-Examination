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
        left_index = 0
        right_index = 0

        while left_index < len(left) and right_index < len(right):
            if left[left_index] <= right[right_index]:
                result.append(left[left_index])
                left_index += 1

            else:
                result.append(right[right_index])
                right_index += 1

        if left:
            result.extend(left[left_index:])

        if right:
            result.extend(right[right_index:])

        return result
