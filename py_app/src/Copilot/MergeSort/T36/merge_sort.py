class MergeSort:
    def merge_sort(self, data):
        if len(data) > 1:
            mid = len(data) // 2
            left_half = data[:mid]
            right_half = data[mid:]
            self.merge_sort(left_half)
            self.merge_sort(right_half)
            i = 0
            j = 0
            k = 0
            while i < len(left_half) and j < len(right_half):
                if left_half[i] < right_half[j]:
                    data[k] = left_half[i]
                    i = i + 1
                else:
                    data[k] = right_half[j]
                    j = j + 1
                k = k + 1
            while i < len(left_half):
                data[k] = left_half[i]
                i = i + 1
                k = k + 1
            while j < len(right_half):
                data[k] = right_half[j]
                j = j + 1
                k = k + 1
        return data
