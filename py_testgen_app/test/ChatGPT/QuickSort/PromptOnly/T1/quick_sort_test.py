from py_testgen_app.src.ChatGPT.QuickSort.PromptOnly.T1.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort_empty_list(self):
        # Test sorting an empty list
        arr = []
        QuickSort().sort(arr)
        self.assertEqual(arr, [])

    def test_sort_sorted_list(self):
        # Test sorting an already sorted list
        arr = [1, 2, 3, 4, 5]
        QuickSort().sort(arr)
        self.assertEqual(arr, [1, 2, 3, 4, 5])

    def test_sort_reverse_sorted_list(self):
        # Test sorting a reverse-sorted list
        arr = [5, 4, 3, 2, 1]
        QuickSort().sort(arr)
        self.assertEqual(arr, [1, 2, 3, 4, 5])

    def test_sort_random_list(self):
        # Test sorting a random list
        arr = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        QuickSort().sort(arr)
        self.assertEqual(arr, [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9])