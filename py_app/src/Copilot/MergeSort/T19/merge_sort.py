class MergeSort:
    def merge_sort(self, list):
        if len(list) <= 1:
            return list
        left_half, right_half = self.split(list)
        left = self.merge_sort(left_half)
        right = self.merge_sort(right_half)
        return self.merge(left, right)

    def split(self, list):
        mid = len(list)//2
        left = list[:mid]
        right = list[mid:]
        return left, right

    def merge(self, left, right):
        l = []
        i = 0
        j = 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
              l.append(left[i])
              i += 1
            else:
                l.append(right[j])
                j += 1
        while i < len(left):
            l.append(left[i])
            i += 1
        while j < len(right):
            l.append(right[j])
            j += 1
        return l
