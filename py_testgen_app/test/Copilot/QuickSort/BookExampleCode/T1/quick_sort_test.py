from py_testgen_app.src.Copilot.QuickSort.BookExampleCode.T1.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def setUp(self):
        self.quick_sort = QuickSort()

    def test_quick_sort(self):
        unsorted_array = [2, 1, 3]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3])

    def test_quick_sort_empty(self):
        unsorted_array = []
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [])

    def test_quick_sort_already_sorted(self):
        unsorted_array = [1, 2, 3]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3])

    def test_quick_sort_reverse_sorted(self):
        unsorted_array = [3, 2, 1]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3])

    def test_quick_sort_duplicates(self):
        unsorted_array = [3, 2, 1, 3, 2, 1]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 1, 2, 2, 3, 3])

    def test_quick_sort_duplicates2(self):
        unsorted_array = [3, 2, 1, 3, 2, 1, 0]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [0, 1, 1, 2, 2, 3, 3])