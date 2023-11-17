class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr
        else:
            pivot = arr[0]
            left = []
            right = []
            for element in arr[1:]:
                if element < pivot:
                    left.append(element)
                else:
                    right.append(element)
            return self.sort(left) + [pivot] + self.sort(right)
