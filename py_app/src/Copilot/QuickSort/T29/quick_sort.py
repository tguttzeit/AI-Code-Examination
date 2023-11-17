class QuickSort:

    def sort(self, array):
        if len(array) <= 1:
            return array
        pivot = array[0]
        left = []
        right = []
        for x in array[1:]:
            if x < pivot:
                left.append(x)
            else:
                right.append(x)
        return self.sort(left) + [pivot] + self.sort(right)
