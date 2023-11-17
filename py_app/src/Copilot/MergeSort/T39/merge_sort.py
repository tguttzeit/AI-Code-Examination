class MergeSort:
    @staticmethod
    def merge_sort(array):
        if len(array) <= 1:
            return array
        mid = len(array) // 2
        left = MergeSort.merge_sort(array[:mid])
        right = MergeSort.merge_sort(array[mid:])
        return MergeSort.merge(left, right)

    @staticmethod
    def merge(left, right):
        result = []
        while len(left) > 0 and len(right) > 0:
            if left[0] <= right[0]:
                result.append(left.pop(0))
            else:
                result.append(right.pop(0))

        if len(left) > 0:
            result.extend(left)
        if len(right) > 0:
            result.extend(right)

        return result
