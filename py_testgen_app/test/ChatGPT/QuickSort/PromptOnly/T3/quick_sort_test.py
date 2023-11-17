from py_testgen_app.src.ChatGPT.QuickSort.PromptOnly.T3.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort_empty_list(self):
        # Test sorting an empty list
        input_list = []
        quick_sort = QuickSort()
        quick_sort.sort(input_list)
        self.assertEqual(input_list, [])

    def test_sort_sorted_list(self):
        # Test sorting a sorted list
        input_list = [1, 2, 3, 4, 5]
        quick_sort = QuickSort()
        quick_sort.sort(input_list)
        self.assertEqual(input_list, [1, 2, 3, 4, 5])

    def test_sort_reverse_sorted_list(self):
        # Test sorting a reverse-sorted list
        input_list = [5, 4, 3, 2, 1]
        quick_sort = QuickSort()
        quick_sort.sort(input_list)
        self.assertEqual(input_list, [1, 2, 3, 4, 5])