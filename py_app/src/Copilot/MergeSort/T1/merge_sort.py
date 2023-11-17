class MergeSort:
    def merge_sort(self, list):
        # check if list is empty
        if len(list) <= 1:
            return list
        # split list into two lists
        mid = len(list) // 2
        left = list[:mid]
        right = list[mid:]
        # recursively call merge_sort on left and right lists
        left = self.merge_sort(left)
        right = self.merge_sort(right)
        # merge left and right lists
        return self.merge(left, right)

    def merge(self, left, right):
        # check if lists are empty
        if len(left) == 0:
            return right
        if len(right) == 0:
            return left
        # initialize merged list
        merged = []
        # initialize indices
        left_index = 0
        right_index = 0
        # loop until all elements are merged
        while len(merged) < len(left) + len(right):
            # check if left element is smaller than right element
            if left[left_index] <= right[right_index]:
                # add left element to merged list
                merged.append(left[left_index])
                # increase left index
                left_index += 1
            else:
                # add right element to merged list
                merged.append(right[right_index])
                # increase right index
                right_index += 1
            # check if left index reached the end of left list
            if left_index == len(left):
                # add remaining elements of right list to merged list
                merged += right[right_index:]
                break
            # check if right index reached the end of right list
            if right_index == len(right):
                # add remaining elements of left list to merged list
                merged += left[left_index:]
                break
        return merged
