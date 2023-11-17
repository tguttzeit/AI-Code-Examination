class BinarySearch:

    def binary_search(self, value, list):
        # 1. Sort the list
        list.sort()
        # 2. Set the low and high indexes
        low = 0
        high = len(list)-1
        # 3. While the low index is less than or equal to the high index
        while low <= high:
            # 4. Set the mid index
            mid = (low + high) // 2
            # 5. If the value is equal to the value at the mid index
            if value == list[mid]:
                # 6. Return True
                return True
            # 7. If the value is less than the value at the mid index
            elif value < list[mid]:
                # 8. Set the high index to the mid index minus one
                high = mid - 1
            # 9. Else
            else:
                # 10. Set the low index to the mid index plus one
                low = mid + 1
        # 11. Return False
        return False
