from py_testgen_app.src.Copilot.QuickSort.AIGenerated.T10.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort(self):
        unsorted_array = [5, 4, 3, 2, 1]
        quick_sort = QuickSort()
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])

        unsorted_array = [5, 4, 3, 2, 1, 0]
        quick_sort = QuickSort()
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [0, 1, 2, 3, 4, 5])

        unsorted_array = [5, 4, 3, 2, 1, 0, -1]
        quick_sort = QuickSort()
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [-1, 0, 1, 2, 3, 4, 5])