class MergeSort:
    def __init__(self):
        pass

    def merge_sort(self, arr):
        if len(arr) <= 1:
            return arr

        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]

        left = self.merge_sort(left)
        right = self.merge_sort(right)

        return list(self.merge(left, right))

    def merge(self, left, right):
        if len(left) == 0:
            return right

        if len(right) == 0:
            return left

        result = []
        left_index = right_index = 0

        while len(result) < len(left) + len(right):
            if left[left_index] <= right[right_index]:
                result.append(left[left_index])
                left_index += 1
            else:
                result.append(right[right_index])
                right_index += 1

            if right_index == len(right):
                result += left[left_index:]
                break

            if left_index == len(left):
                result += right[right_index:]
                break

        return result
