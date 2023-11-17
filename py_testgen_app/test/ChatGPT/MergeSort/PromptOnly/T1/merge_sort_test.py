from py_testgen_app.src.ChatGPT.MergeSort.PromptOnly.T1.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_sort_empty_list(self):
        input_list = []
        sorted_list = MergeSort().merge_sort(input_list)
        self.assertEqual(sorted_list, [])

    def test_sort_sorted_list(self):
        input_list = [1, 2, 3, 4, 5]
        sorted_list = MergeSort().merge_sort(input_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])

    def test_sort_reverse_list(self):
        input_list = [5, 4, 3, 2, 1]
        sorted_list = MergeSort().merge_sort(input_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])