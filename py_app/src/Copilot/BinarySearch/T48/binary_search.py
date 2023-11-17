class BinarySearch:

    def binary_search(self, num, num_list):
        # start = 0
        # end = len(num_list) - 1
        # mid = (start + end) // 2
        # while start <= end:
        #     if num == num_list[mid]:
        #         return True
        #     elif num < num_list[mid]:
        #         end = mid - 1
        #     else:
        #         start = mid + 1
        #     mid = (start + end) // 2
        # return False
        if len(num_list) == 0:
            return False
        else:
            mid = len(num_list) // 2
            if num == num_list[mid]:
                return True
            elif num < num_list[mid]:
                return self.binary_search(num, num_list[:mid])
            else:
                return self.binary_search(num, num_list[mid + 1:])
