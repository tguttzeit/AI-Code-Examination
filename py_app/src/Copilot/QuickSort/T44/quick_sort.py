class QuickSort:
    def sort(self, nums):
        # Call the recursive quick sort method
        self.quick_sort(nums, 0, len(nums) - 1)

    def quick_sort(self, nums, low, high):
        # Check if the low and high indices are valid
        if low < high:
            # Partition the list
            partition_index = self.partition(nums, low, high)

            # Recursively sort the left and right sublists
            self.quick_sort(nums, low, partition_index - 1)
            self.quick_sort(nums, partition_index + 1, high)

    def partition(self, nums, low, high):
        # Set the pivot value to be the last element in the list
        pivot = nums[high]

        # Set the partition index to be the low index
        partition_index = low

        # Iterate through the list from low to high
        for i in range(low, high):
            # If the current element is less than the pivot
            if nums[i] <= pivot:
                # Swap the current element with the element at the partition index
                nums[i], nums[partition_index] = nums[partition_index], nums[i]

                # Increment the partition index
                partition_index += 1

        # Swap the pivot with the element at the partition index
        nums[high], nums[partition_index] = nums[partition_index], nums[high]

        # Return the partition index
        return partition_index
