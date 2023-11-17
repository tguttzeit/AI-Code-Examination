# Source: https://www.geeksforgeeks.org/python-program-for-quicksort/

# CHANGE FOR EXPERIMENT: Some methods got refactored to fit in the class
class QuickSort:
    # Python program for implementation of Quicksort Sort

    # This implementation utilizes pivot as the last element in the nums list
    # It has a pointer to keep track of the elements smaller than the pivot
    # At the very end of partition() function, the pointer is swapped with the pivot
    # to come up with a "sorted" nums relative to the pivot

    # Function to find the partition position
    def partition(self, array, low, high):

        # choose the rightmost element as pivot
        pivot = array[high]

        # pointer for greater element
        i = low - 1

        # traverse through all elements
        # compare each element with pivot
        for j in range(low, high):
            if array[j] <= pivot:
                # If element smaller than pivot is found
                # swap it with the greater element pointed by i
                i = i + 1

                # Swapping element at i with element at j
                (array[i], array[j]) = (array[j], array[i])

        # Swap the pivot element with the greater element specified by i
        (array[i + 1], array[high]) = (array[high], array[i + 1])

        # Return the position from where partition is done
        return i + 1

    # function to perform quicksort

    def quick_sort(self, array, low, high):  # CHANGE FOR EXPERIMENT: Changed to snake_case
        if low < high:
            # Find pivot element such that
            # element smaller than pivot are on the left
            # element greater than pivot are on the right
            pi = self.partition(array, low, high)

            # Recursive call on the left of pivot
            self.quick_sort(array, low, pi - 1)

            # Recursive call on the right of pivot
            self.quick_sort(array, pi + 1, high)

    # CHANGE FOR EXPERIMENT: This method is not used in the source, but is needed for the tests.
    def sort(self, unsorted_array):
        self.quick_sort(unsorted_array, 0, len(unsorted_array) - 1)
