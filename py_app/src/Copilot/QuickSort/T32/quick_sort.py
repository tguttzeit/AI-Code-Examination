class QuickSort:
    def sort(self, list):
        self.quickSort(list, 0, len(list) - 1)

    def quickSort(self, list, low, high):
        if low < high:
            pivot = self.partition(list, low, high)
            self.quickSort(list, low, pivot - 1)
            self.quickSort(list, pivot + 1, high)

    def partition(self, list, low, high):
        pivot = list[high]
        i = low - 1
        for j in range(low, high):
            if list[j] <= pivot:
                i += 1
                self.swap(list, i, j)
        self.swap(list, i + 1, high)
        return i + 1

    def swap(self, list, i, j):
        list[i], list[j] = list[j], list[i]
