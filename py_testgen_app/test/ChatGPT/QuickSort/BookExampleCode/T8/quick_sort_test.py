from py_testgen_app.src.ChatGPT.QuickSort.BookExampleCode.T8.quick_sort import QuickSort

import unittest

class TestQuickSort(unittest.TestCase):
    def setUp(self):
        self.quick_sort = QuickSort()

    def test_empty_array(self):
        unsorted_array = []
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [])

    def test_sorted_array(self):
        unsorted_array = [1, 2, 3, 4, 5]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])

    def test_reverse_sorted_array(self):
        unsorted_array = [5, 4, 3, 2, 1]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])

    def test_random_order_array(self):
        unsorted_array = [3, 1, 4, 2, 5]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])
