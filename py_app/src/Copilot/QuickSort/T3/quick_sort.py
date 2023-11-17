class QuickSort:

    def __init__(self, arr):
        self.arr = arr

    def sort(self, arr):
        if len(arr) <= 1:
            return arr
        else:
            pivot = arr.pop()

        items_greater = []
        items_lower = []

        for item in arr:
            if item > pivot:
                items_greater.append(item)

            else:
                items_lower.append(item)

        return self.sort(items_lower) + [pivot] + self.sort(items_greater)
