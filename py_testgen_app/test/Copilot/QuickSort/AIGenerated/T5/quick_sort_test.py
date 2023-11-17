from py_testgen_app.src.Copilot.QuickSort.AIGenerated.T5.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_quick_sort(self):
        quick_sort = QuickSort()
        unsorted_array = [4, 2, 1, 3]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4])

        unsorted_array = [4, 2, 1, 3, 5, 7, 6]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7])

        unsorted_array = [4, 2, 1, 3, 2, 5, 7, 6]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 2, 3, 4, 5, 6, 7])

        unsorted_array = [4, 2, 1, 3, 2, 5, 7, 6, 9, 8]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 2, 3, 4, 5, 6, 7, 8, 9])

        unsorted_array = [4, 2, 1, 3, 2, 5, 7, 6, 9, 8, 0]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [0, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9])