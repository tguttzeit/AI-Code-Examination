class QuickSort:
    def __init__(self, list):
        self.list = list

    def sort(self):
        self.quick_sort(self.list, 0, len(self.list)-1)

    def quick_sort(self, list, low, high):
        if low < high:
            p = self.partition(list, low, high)
            self.quick_sort(list, low, p - 1)
            self.quick_sort(list, p + 1, high)

    def partition(self, list, low, high):
        pivot = list[high]
        i = low - 1
        for j in range(low, high):
            if list[j] <= pivot:
                i += 1
                list[i], list[j] = list[j], list[i]
        list[i + 1], list[high] = list[high], list[i + 1]
        return i + 1
