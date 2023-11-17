from py_testgen_app.src.ChatGPT.QuickSort.BookExampleCode.T5.quick_sort import QuickSort

import unittest

class TestQuickSort(unittest.TestCase):

    def test_empty_list(self):
        sorter = QuickSort()
        unsorted_array = []
        sorter.sort(unsorted_array)
        self.assertEqual(unsorted_array, [])

    def test_sorted_list(self):
        sorter = QuickSort()
        unsorted_array = [1, 2, 3, 4, 5]
        sorter.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        sorter = QuickSort()
        unsorted_array = [5, 4, 3, 2, 1]
        sorter.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])

    def test_random_list(self):
        sorter = QuickSort()
        unsorted_array = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        sorter.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9])
