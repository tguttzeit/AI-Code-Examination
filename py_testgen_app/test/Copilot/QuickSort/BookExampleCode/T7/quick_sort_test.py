from py_testgen_app.src.Copilot.QuickSort.BookExampleCode.T7.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def setUp(self):
        self.quick_sort = QuickSort()

    def test_empty_array(self):
        unsorted_array = []
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [])

    def test_one_element(self):
        unsorted_array = [1]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1])

    def test_sorted_array(self):
        unsorted_array = [1, 2, 3, 4, 5]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])

    def test_unsorted_array(self):
        unsorted_array = [5, 4, 3, 2, 1]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])