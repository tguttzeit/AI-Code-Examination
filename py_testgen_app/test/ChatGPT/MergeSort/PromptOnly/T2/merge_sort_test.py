from py_testgen_app.src.ChatGPT.MergeSort.PromptOnly.T2.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_empty_list(self):
        sorter = MergeSort()
        input_list = []
        result = sorter.merge_sort(input_list)
        self.assertEqual(result, [])

    def test_sorted_list(self):
        sorter = MergeSort()
        input_list = [1, 2, 3, 4, 5]
        result = sorter.merge_sort(input_list)
        self.assertEqual(result, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        sorter = MergeSort()
        input_list = [5, 4, 3, 2, 1]
        result = sorter.merge_sort(input_list)
        self.assertEqual(result, [1, 2, 3, 4, 5])

    def test_random_list(self):
        sorter = MergeSort()
        input_list = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        result = sorter.merge_sort(input_list)
        self.assertEqual(result, [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9])