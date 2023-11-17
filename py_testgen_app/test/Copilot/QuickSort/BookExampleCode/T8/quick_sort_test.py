from py_testgen_app.src.Copilot.QuickSort.BookExampleCode.T8.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def setUp(self):
        self.quick_sort = QuickSort()

    def test_sort(self):
        unsorted_array = [5, 4, 3, 2, 1]
        sorted_array = [1, 2, 3, 4, 5]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, sorted_array)

    def test_sort2(self):
        unsorted_array = [3, 2, 1]
        sorted_array = [1, 2, 3]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, sorted_array)

    def test_sort3(self):
        unsorted_array = [1]
        sorted_array = [1]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, sorted_array)