class MergeSort:
    def merge_sort(self, list):
        # print(list)
        if len(list) <= 1:
            return list
        mid = len(list) // 2
        left = list[:mid]
        right = list[mid:]
        left = self.merge_sort(left)
        right = self.merge_sort(right)
        return self.merge(left, right)

    def merge(self, left, right):
        # print(left, right)
        result = []
        while len(left) > 0 and len(right) > 0:
            if left[0] < right[0]:
                # print(left[0], right[0])
                result.append(left[0])
                left.pop(0)
            else:
                result.append(right[0])
                right.pop(0)
        if len(left) > 0:
            result.extend(left)
        if len(right) > 0:
            result.extend(right)
        # print(result)
        return result
