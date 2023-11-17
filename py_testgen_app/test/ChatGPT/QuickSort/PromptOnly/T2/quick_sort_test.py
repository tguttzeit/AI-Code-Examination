from py_testgen_app.src.ChatGPT.QuickSort.PromptOnly.T2.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_empty_list(self):
        qs = QuickSort()
        input_list = []
        qs.sort(input_list)
        self.assertEqual(input_list, [])

    def test_sorted_list(self):
        qs = QuickSort()
        input_list = [1, 2, 3, 4, 5]
        qs.sort(input_list)
        self.assertEqual(input_list, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        qs = QuickSort()
        input_list = [5, 4, 3, 2, 1]
        qs.sort(input_list)
        self.assertEqual(input_list, [1, 2, 3, 4, 5])

    def test_random_list(self):
        qs = QuickSort()
        input_list = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        qs.sort(input_list)
        self.assertEqual(input_list, [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9])