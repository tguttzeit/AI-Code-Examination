class MergeSort:
    def merge_sort(self, list):
        if len(list) <= 1:
            return list

        middle = len(list) // 2
        left_list = list[:middle]
        right_list = list[middle:]

        left_list = self.merge_sort(left_list)
        right_list = self.merge_sort(right_list)
        return list(self.merge(left_list, right_list))

    def merge(self, left_list, right_list):
        res = []
        while len(left_list) != 0 and len(right_list) != 0:
            if left_list[0] < right_list[0]:
                res.append(left_list[0])
                left_list.remove(left_list[0])
            else:
                res.append(right_list[0])
                right_list.remove(right_list[0])
        if len(left_list) == 0:
            res = res + right_list
        else:
            res = res + left_list
        return res
