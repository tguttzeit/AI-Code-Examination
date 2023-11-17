class MergeSort:
    def merge_sort(self, list):
        if len(list) <= 1:
            return list
        else:
            mid = len(list) // 2
            left = list[:mid]
            right = list[mid:]
            left = self.merge_sort(left)
            right = self.merge_sort(right)
            return list(self.merge(left, right))

    def merge(self, left, right):
        res = []
        while len(left) != 0 and len(right) != 0:
            if left[0] < right[0]:
                res.append(left[0])
                left.remove(left[0])
            else:
                res.append(right[0])
                right.remove(right[0])
        if len(left) == 0:
            res += right
        else:
            res += left
        return res