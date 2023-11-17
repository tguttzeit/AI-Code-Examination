from py_testgen_app.src.ChatGPT.QuickSort.AIGenerated.T3.quick_sort import QuickSort

import unittest

class TestQuickSort(unittest.TestCase):

    def setUp(self):
        self.quick_sort = QuickSort()

    def test_empty_list(self):
        unsorted_array = []
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [])

    def test_sorted_list(self):
        unsorted_array = [1, 2, 3, 4, 5]
        expected_result = [1, 2, 3, 4, 5]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, expected_result)

    def test_reverse_sorted_list(self):
        unsorted_array = [5, 4, 3, 2, 1]
        expected_result = [1, 2, 3, 4, 5]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, expected_result)

    def test_unsorted_list(self):
        unsorted_array = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        expected_result = [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, expected_result)
