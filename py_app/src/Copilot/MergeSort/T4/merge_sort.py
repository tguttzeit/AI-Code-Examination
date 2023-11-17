class MergeSort:
    def merge_sort(self, array: list[int]) -> list[int]:
        if len(array) <= 1:
            return array
        else:
            mid = len(array) // 2
            left = self.merge_sort(array[:mid])
            right = self.merge_sort(array[mid:])
            return self.merge(left, right)

    def merge(self, left: list[int], right: list[int]) -> list[int]:
        result = []
        left_index = 0
        right_index = 0
        while len(left) > left_index and len(right) > right_index:
            if left[left_index] > right[right_index]:
                result.append(right[right_index])
                right_index += 1
            else:
                result.append(left[left_index])
                left_index += 1
        result += left[left_index:]
        result += right[right_index:]
        return result
