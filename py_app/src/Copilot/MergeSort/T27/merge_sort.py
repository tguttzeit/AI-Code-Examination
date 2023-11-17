class MergeSort:
    def merge_sort(self, list):
        if len(list) <= 1:
            return list
        else:
            middle = len(list) // 2
            left_list = list[:middle]
            right_list = list[middle:]

            left_list = self.merge_sort(left_list)
            right_list = self.merge_sort(right_list)
            return self.merge(left_list, right_list)

    def merge(self, left_half, right_half):
        res = []
        while len(left_half) != 0 and len(right_half) != 0:
            if left_half[0] < right_half[0]:
                res.append(left_half[0])
                left_half.remove(left_half[0])
            else:
                res.append(right_half[0])
                right_half.remove(right_half[0])
        if len(left_half) > 0:
            res = res + left_half
        else:
            res = res + right_half
        return res