class BinarySearch:

    def binary_search(self, search_list, target):
        left = 0
        right = len(search_list) - 1
        while left <= right:
            middle = (left + right) // 2
            if search_list[middle] == target:
                return True
            elif search_list[middle] < target:
                left = middle + 1
            else:
                right = middle - 1
        return False
