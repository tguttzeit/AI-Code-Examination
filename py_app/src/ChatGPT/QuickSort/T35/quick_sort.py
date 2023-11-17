class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        def partition(arr, low, high):
            pivot = arr[low]
            left = low + 1
            right = high

            done = False
            while not done:
                while left <= right and arr[left] <= pivot:
                    left = left + 1
                while arr[right] >= pivot and right >= left:
                    right = right - 1
                if right < left:
                    done = True
                else:
                    arr[left], arr[right] = arr[right], arr[left]

            arr[low], arr[right] = arr[right], arr[low]
            return right

        def quicksort(arr, low, high):
            if low < high:
                pivot_index = partition(arr, low, high)
                quicksort(arr, low, pivot_index - 1)
                quicksort(arr, pivot_index + 1, high)

        quicksort(arr, 0, len(arr) - 1)
