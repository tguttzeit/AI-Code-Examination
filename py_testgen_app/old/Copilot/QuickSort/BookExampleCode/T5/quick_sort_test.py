from py_testgen_app.src.Copilot.QuickSort.BookExampleCode.T5.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort(self):
        quick_sort = QuickSort()
        unsorted_array = [5, 3, 6, 2, 7, 1, 4]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7])

    def test_sort_with_negative(self):
        quick_sort = QuickSort()
        unsorted_array = [5, -3, 6, 2, -7, 1, 4]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [-7, -3, 1, 2, 4, 5, 6])

    def test_sort_with_empty(self):
        quick_sort = QuickSort()
        unsorted_array = []
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [])

    def test_sort_with_one(self):
        quick_sort = QuickSort()
        unsorted_array = [1]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1])

    def test_sort_with_two(self):
        quick_sort = QuickSort()
        unsorted_array = [2, 1]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2])

    def test_sort_with_sorted(self):
        quick_sort = QuickSort()
        unsorted_array = [1, 2, 3, 4, 5, 6, 7]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7])

    def test_sort_with_reverse_sorted(self):
        quick_sort = QuickSort()
        unsorted_array = [7, 6, 5, 4, 3, 2, 1]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7])

    def test_sort_with_duplicates(self):
        quick_sort = QuickSort()
        unsorted_array = [7, 6, 5, 4, 3, 2, 1, 1, 1]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 1