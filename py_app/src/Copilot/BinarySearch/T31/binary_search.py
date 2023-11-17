class BinarySearch:

    def binary_search(self, value, sorted_list):
        # if value is None or sorted_list is None:
        #     raise TypeError("Value or sorted_list cannot be None.")
        # if len(sorted_list) == 0:
        #     raise ValueError("Sorted_list cannot be empty.")

        left = 0
        right = len(sorted_list) - 1

        while left <= right:
            middle = (left + right) // 2
            if sorted_list[middle] == value:
                return True
            elif sorted_list[middle] < value:
                left = middle + 1
            else:
                right = middle - 1

        return False
