from py_testgen_app.src.Copilot.MergeSort.PromptOnly.T1.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort(self):
        # Test case 1
        # Arrange
        merge_sort = MergeSort()
        input_ = [5, 2, 3, 1, 4]
        expected_output = [1, 2, 3, 4, 5]
        # Act
        actual_output = merge_sort.merge_sort(input_)
        # Assert
        self.assertEqual(actual_output, expected_output)

        # Test case 2
        # Arrange
        merge_sort = MergeSort()
        input_ = [3, 2, 1, 4]
        expected_output = [1, 2, 3, 4]
        # Act
        actual_output = merge_sort.merge_sort(input_)
        # Assert
        self.assertEqual(actual_output, expected_output)

        # Test case 3
        # Arrange
        merge_sort = MergeSort()
        input_ = [1, 2, 3, 4]
        expected_output = [1, 2, 3, 4]
        # Act
        actual_output = merge_sort.merge_sort(input_)
        # Assert
        self.assertEqual(actual_output, expected_output)

        # Test case 4
        # Arrange
        merge_sort = MergeSort()
        input_ = [5, 4, 3, 2, 1]
        expected_output = [1, 2, 3, 4, 5]
        # Act
        actual_output = merge_sort.merge_sort(input_)
        # Assert
        self.assertEqual(actual_output, expected_output)

        # Test case 5
        # Arrange
        merge_sort = MergeSort()
        input_ = [1]
        expected_output = [1]
        # Act
        actual_output = merge_sort.merge_sort(input_)
        # Assert
        self.assertEqual(actual_output, expected_output)

        # Test case 6
        # Arrange
        merge_sort = MergeSort()
        input_ = []
        expected_output = []
        # Act
        actual_output = merge_sort.merge_sort(input_)
        # Assert
        self.assertEqual(actual_output, expected_output)

        # Test case 7
        # Arrange
        merge_sort = MergeSort()
        input_ = [1, 2, 3, 4, 5]
        expected_output = [1, 2, 3, 4, 5]
        #