class MergeSort:
    def merge_sort(self, array):
        if len(array) <= 1:
            return array

        mid = len(array) // 2
        left = array[:mid]
        right = array[mid:]

        left = self.merge_sort(left)
        right = self.merge_sort(right)

        return list(self.merge(left, right))

    def merge(self, left, right):
        left_index, right_index = 0, 0
        result = []
        while left_index < len(left) and right_index < len(right):
            # change the direction of this comparison to change the direction of the sort
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
