class QuickSort:
    def sort(self, numbers):
        self.quicksort(numbers, 0, len(numbers)-1)

    def quicksort(self, numbers, lo, hi):
        if lo < hi:
            p = self.partition(numbers, lo, hi)
            self.quicksort(numbers, lo, p-1)
            self.quicksort(numbers, p+1, hi)

    def partition(self, numbers, lo, hi):
        pivot = numbers[hi]
        i = lo
        for j in range(lo, hi):
            if numbers[j] < pivot:
                numbers[i], numbers[j] = numbers[j], numbers[i]
                i += 1
        numbers[i], numbers[hi] = numbers[hi], numbers[i]
        return i
