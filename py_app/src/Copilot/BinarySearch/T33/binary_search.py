class BinarySearch:

    def binary_search(self, search_int, int_list):

        # int_list.sort()

        # print(int_list)
        # print(search_int)

        left = 0
        right = len(int_list) - 1

        while left <= right:
            middle = (left + right) // 2
            if int_list[middle] == search_int:
                return True
            elif int_list[middle] > search_int:
                right = middle - 1
            else:
                left = middle + 1
        return False
