from py_testgen_app.src.ChatGPT.MergeSort.PromptOnly.T7.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_empty_list(self):
        arr = []
        sorted_arr = MergeSort().merge_sort(arr)
        self.assertEqual(sorted_arr, [])

    def test_sorted_list(self):
        arr = [1, 2, 3, 4, 5]
        sorted_arr = MergeSort().merge_sort(arr)
        self.assertEqual(sorted_arr, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        arr = [5, 4, 3, 2, 1]
        sorted_arr = MergeSort().merge_sort(arr)
        self.assertEqual(sorted_arr, [1, 2, 3, 4, 5])