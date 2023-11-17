from py_testgen_app.src.Copilot.QuickSort.AIGenerated.T9.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_quick_sort(self):
        unsorted_array = [5, 1, 3, 2, 4]
        expected = [1, 2, 3, 4, 5]
        quick_sort = QuickSort()
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, expected)

    def test_quick_sort_2(self):
        unsorted_array = [5, 1, 3, 2, 4, 6, 8, 7]
        expected = [1, 2, 3, 4, 5, 6, 7, 8]
        quick_sort = QuickSort()
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, expected)

    def test_quick_sort_3(self):
        unsorted_array = [5, 1, 3, 2, 4, 6, 8, 7, 10, 9]
        expected = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        quick_sort = QuickSort()
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, expected)