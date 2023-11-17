class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr
        pivot = arr[0]
        left = []
        right = []
        for x in arr[1:]:
            if x < pivot:
                left.append(x)
            else:
                right.append(x)
        return self.sort(left) + [pivot] + self.sort(right)
