from py_testgen_app.src.Copilot.QuickSort.AIGenerated.T1.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_quick_sort(self):
        unsorted_array = [9, 5, 3, 7, 2, 8, 1, 10, 6, 4]
        quick_sort = QuickSort()
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])

        unsorted_array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        quick_sort = QuickSort()
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])

        unsorted_array = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        quick_sort = QuickSort()
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])