from py_testgen_app.src.ChatGPT.QuickSort.PromptOnly.T4.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_empty_list(self):
        input_list = []
        QuickSort().sort(input_list)
        self.assertEqual(input_list, [])

    def test_sorted_list(self):
        input_list = [1, 2, 3, 4, 5]
        QuickSort().sort(input_list)
        self.assertEqual(input_list, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        input_list = [5, 4, 3, 2, 1]
        QuickSort().sort(input_list)
        self.assertEqual(input_list, [1, 2, 3, 4, 5])

    def test_random_list(self):
        input_list = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        QuickSort().sort(input_list)
        self.assertEqual(input_list, [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9])