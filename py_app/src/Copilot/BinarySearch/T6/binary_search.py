class BinarySearch:
    def binary_search(self, target, nums):
        # Implement the binary search algorithm
        # Assume the input list will always be sorted
        # Return True if the target is found
        # Return False if the target is not found
        # return self.binary_search_recursive(target, nums, 0, len(nums) - 1)
        return self.binary_search_iterative(target, nums)

    def binary_search_recursive(self, target, nums, left, right):
        if left > right:
            return False

        mid = (left + right) // 2

        if target == nums[mid]:
            return True
        elif target < nums[mid]:
            return self.binary_search_recursive(target, nums, left, mid - 1)
        else:
            return self.binary_search_recursive(target, nums, mid + 1, right)

    def binary_search_iterative(self, target, nums):
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            if target == nums[mid]:
                return True
            elif target < nums[mid]:
                right = mid - 1
            else:
                left = mid + 1

        return False
