class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr
        else:
            pivot = arr[0]
            less_than_pivot = [x for x in arr[1:] if x <= pivot]
            greater_than_pivot = [x for x in arr[1:] if x > pivot]

            self.sort(less_than_pivot)
            self.sort(greater_than_pivot)

            arr[:] = less_than_pivot + [pivot] + greater_than_pivot