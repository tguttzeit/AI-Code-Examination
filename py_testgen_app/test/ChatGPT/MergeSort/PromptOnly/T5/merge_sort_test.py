from py_testgen_app.src.ChatGPT.MergeSort.PromptOnly.T5.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_empty_list(self):
        input_list = []
        sorted_list = MergeSort().merge_sort(input_list)
        self.assertEqual(sorted_list, [])

    def test_sorted_list(self):
        input_list = [1, 2, 3, 4, 5]
        sorted_list = MergeSort().merge_sort(input_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        input_list = [5, 4, 3, 2, 1]
        sorted_list = MergeSort().merge_sort(input_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])