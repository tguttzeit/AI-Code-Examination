from py_testgen_app.src.ChatGPT.MergeSort.PromptOnly.T9.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_empty_list(self):
        self.assertEqual(MergeSort.merge_sort([]), [])

    def test_sorted_list(self):
        input_list = [1, 2, 3, 4, 5]
        self.assertEqual(MergeSort.merge_sort(input_list), [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        input_list = [5, 4, 3, 2, 1]
        self.assertEqual(MergeSort.merge_sort(input_list), [1, 2, 3, 4, 5])
