class MergeSort:
    def merge_sort(self, a_list):
        if len(a_list) <= 1:
            return a_list

        mid = len(a_list) // 2
        left_half = a_list[:mid]
        right_half = a_list[mid:]

        left_half = self.merge_sort(left_half)
        right_half = self.merge_sort(right_half)

        return self.merge(left_half, right_half)

    def merge(self, left_half, right_half):
        res = []

        while len(left_half) != 0 and len(right_half) != 0:
            if left_half[0] < right_half[0]:
                res.append(left_half[0])
                left_half.remove(left_half[0])
            else:
                res.append(right_half[0])
                right_half.remove(right_half[0])

        if len(left_half) == 0:
            res = res + right_half
        else:
            res = res + left_half

        return res
