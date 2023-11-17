class QuickSort:
    def __init__(self):
        pass

    def sort(self, a):
        self.sort_helper(a, 0, len(a) - 1)

    def sort_helper(self, a, lo, hi):
        if lo >= hi:
            return
        j = self.partition(a, lo, hi)
        self.sort_helper(a, lo, j - 1)
        self.sort_helper(a, j + 1, hi)

    def partition(self, a, lo, hi):
        i = lo
        j = hi + 1
        v = a[lo]
        while True:
            while True:
                i += 1
                if not (i < hi and a[i] < v):
                    break
            while True:
                j -= 1
                if not (j > lo and a[j] > v):
                    break
            if i >= j:
                break
            self.exchange(a, i, j)
        self.exchange(a, lo, j)
        return j

    def exchange(self, a, i, j):
        temp = a[i]
        a[i] = a[j]
        a[j] = temp
