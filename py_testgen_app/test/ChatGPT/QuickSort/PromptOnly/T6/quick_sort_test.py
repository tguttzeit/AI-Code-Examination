from py_testgen_app.src.ChatGPT.QuickSort.PromptOnly.T6.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort_empty_list(self):
        arr = []
        QuickSort().sort(arr)
        self.assertEqual(arr, [])

    def test_sort_sorted_list(self):
        arr = [1, 2, 3, 4, 5]
        QuickSort().sort(arr)
        self.assertEqual(arr, [1, 2, 3, 4, 5])

    def test_sort_reverse_sorted_list(self):
        arr = [5, 4, 3, 2, 1]
        QuickSort().sort(arr)
        self.assertEqual(arr, [1, 2, 3, 4, 5])