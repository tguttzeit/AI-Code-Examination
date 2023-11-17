class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr
        else:
            pivot = arr.pop()
            less = []
            greater = []
            for item in arr:
                if item < pivot:
                    less.append(item)
                else:
                    greater.append(item)
            return self.sort(less) + [pivot] + self.sort(greater)
