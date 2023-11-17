class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr
        else:
            pivot = arr[0]
            lesser = [x for x in arr[1:] if x <= pivot]
            greater = [x for x in arr[1:] if x > pivot]
            return self.sort(lesser) + [pivot] + self.sort(greater)