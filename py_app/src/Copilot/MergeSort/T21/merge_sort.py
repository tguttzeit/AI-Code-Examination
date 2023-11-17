class MergeSort:
    def __init__(self):
        pass

    def merge_sort(self, array):
        if len(array) <= 1:
            return array

        middle = len(array) // 2
        left_list = array[:middle]
        right_list = array[middle:]

        left_list = self.merge_sort(left_list)
        right_list = self.merge_sort(right_list)
        return list(self.merge(left_list, right_list))

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
