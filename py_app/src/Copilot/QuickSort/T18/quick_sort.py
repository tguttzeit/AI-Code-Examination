class QuickSort:
    def sort(self, arr):
        self.quick_sort(arr, 0, len(arr) - 1)

    def quick_sort(self, arr, start, end):
        if start < end:
            partition_index = self.partition(arr, start, end)
            self.quick_sort(arr, start, partition_index - 1)
            self.quick_sort(arr, partition_index + 1, end)

    def partition(self, arr, start, end):
        pivot = arr[end]
        partition_index = start
        for i in range(start, end):
            if arr[i] <= pivot:
                arr[i], arr[partition_index] = arr[partition_index], arr[i]
                partition_index += 1
        arr[partition_index], arr[end] = arr[end], arr[partition_index]
        return partition_index
