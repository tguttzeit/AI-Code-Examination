from py_testgen_app.src.Copilot.MergeSort.PromptOnly.T5.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort(self):
        # Arrange
        merge_sort = MergeSort()
        # Act
        sorted_list = merge_sort.merge_sort([5, 4, 3, 2, 1])
        # Assert
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])

    def test_merge_sort_2(self):
        # Arrange
        merge_sort = MergeSort()
        # Act
        sorted_list = merge_sort.merge_sort([5, 4, 3, 2, 1, 0])
        # Assert
        self.assertEqual(sorted_list, [0, 1, 2, 3, 4, 5])

    def test_merge_sort_3(self):
        # Arrange
        merge_sort = MergeSort()
        # Act
        sorted_list = merge_sort.merge_sort([5, 4, 3, 2, 1, 0, -1, -2, -3])
        # Assert
        self.assertEqual(sorted_list, [-3, -2, -1, 0, 1, 2, 3, 4, 5])
