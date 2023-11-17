from py_testgen_app.src.Copilot.MergeSort.PromptOnly.T10.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    # Implement a test method called test_sort_integers() that tests the public method merge_sort() with a list of integers.
    def test_sort_integers(self):
        # Arrange
        test_list = [1, 2, 3, 4, 5]
        expected_result = [1, 2, 3, 4, 5]

        # Act
        result = MergeSort.merge_sort(self, test_list)

        # Assert
        self.assertEqual(expected_result, result)

    # Implement a test method called test_sort_strings() that tests the public method merge_sort() with a list of strings.
    def test_sort_strings(self):
        # Arrange
        test_list = ["b", "a", "c"]
        expected_result = ["a", "b", "c"]

        # Act
        result = MergeSort.merge_sort(self, test_list)

        # Assert
        self.assertEqual(expected_result, result)

    # Implement a test method called test_sort_mixed_list() that tests the public method merge_sort() with a list of mixed values.
    def test_sort_mixed_list(self):
        # Arrange
        test_list = ["b", 1, "a", 2, "c"]
        expected_result = [1, 2, "a", "b", "c"]

        # Act
        result = MergeSort.merge_sort(self, test_list)

        # Assert
        self.assertEqual(expected_result, result)
