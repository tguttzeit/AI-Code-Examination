class QuickSort:
    def __init__(self):
        pass

    def sort(self, arr):
        if len(arr) < 2:
            return arr
        else:
            pivot = arr[0]
            less = [i for i in arr[1:] if i <= pivot]
            greater = [i for i in arr[1:] if i > pivot]
            return self.sort(less) + [pivot] + self.sort(greater)
