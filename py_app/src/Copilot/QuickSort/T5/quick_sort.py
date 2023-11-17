class QuickSort:
    def sort(self, list):
        self.quick_sort(list, 0, len(list) - 1)

    def quick_sort(self, list, left, right):
        if left < right:
            pivot = self.partition(list, left, right)
            self.quick_sort(list, left, pivot - 1)
            self.quick_sort(list, pivot + 1, right)

    def partition(self, list, left, right):
        pivot = list[right]
        i = left - 1
        for j in range(left, right):
            if list[j] <= pivot:
                i += 1
                list[i], list[j] = list[j], list[i]
        list[i + 1], list[right] = list[right], list[i + 1]
        return i + 1
