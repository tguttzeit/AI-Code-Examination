class QuickSort:
    def __init__(self, list):
        self.list = list

    def sort(self):
        self.quickSort(0, len(self.list) - 1)

    def quickSort(self, low, high):
        if low < high:
            pi = self.partition(low, high)
            self.quickSort(low, pi - 1)
            self.quickSort(pi + 1, high)

    def partition(self, low, high):
        i = low - 1
        pivot = self.list[high]

        for j in range(low, high):
            if self.list[j] < pivot:
                i += 1
                self.list[i], self.list[j] = self.list[j], self.list[i]

        self.list[i + 1], self.list[high] = self.list[high], self.list[i + 1]
        return i + 1
