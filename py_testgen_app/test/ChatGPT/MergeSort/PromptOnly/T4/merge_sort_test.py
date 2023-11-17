from py_testgen_app.src.ChatGPT.MergeSort.PromptOnly.T4.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_empty_list(self):
        # Test when an empty list is passed
        input_list = []
        expected_result = []
        result = MergeSort().merge_sort(input_list)
        self.assertEqual(result, expected_result)

    def test_sorted_list(self):
        # Test when an already sorted list is passed
        input_list = [1, 2, 3, 4, 5]
        expected_result = [1, 2, 3, 4, 5]
        result = MergeSort().merge_sort(input_list)
        self.assertEqual(result, expected_result)

    def test_reverse_sorted_list(self):
        # Test when a reverse sorted list is passed
        input_list = [5, 4, 3, 2, 1]
        expected_result = [1, 2, 3, 4, 5]
        result = MergeSort().merge_sort(input_list)
        self.assertEqual(result, expected_result)

    def test_unsorted_list(self):
        # Test when an unsorted list is passed
        input_list = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        expected_result = [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9]
        result = MergeSort().merge_sort(input_list)
        self.assertEqual(result, expected_result)