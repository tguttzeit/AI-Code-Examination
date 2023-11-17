class QuickSort:
    def __init__(self):
        pass

    def sort(self, list):
        self.quick_sort(list, 0, len(list) - 1)

    def quick_sort(self, list, low, high):
        if low < high:
            pivot = self.partition(list, low, high)
            self.quick_sort(list, low, pivot - 1)
            self.quick_sort(list, pivot + 1, high)

    def partition(self, list, low, high):
        pivot = list[high]
        i = low - 1
        for j in range(low, high):
            if list[j] <= pivot:
                i += 1
                list[i], list[j] = list[j], list[i]
        list[i + 1], list[high] = list[high], list[i + 1]
        return i + 1
