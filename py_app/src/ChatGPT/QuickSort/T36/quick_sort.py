class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr
        else:
            pivot = arr[0]
            lesser = []
            greater = []
            equal = []
            for element in arr:
                if element < pivot:
                    lesser.append(element)
                elif element == pivot:
                    equal.append(element)
                else:
                    greater.append(element)

            quick_sort = QuickSort()
            sorted_lesser = quick_sort.sort(lesser)
            sorted_greater = quick_sort.sort(greater)

            arr[:] = sorted_lesser + equal + sorted_greater
