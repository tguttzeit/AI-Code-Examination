from py_testgen_app.src.Copilot.QuickSort.BookExampleCode.T6.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_quick_sort(self):
        quick_sort = QuickSort()
        unsorted_array = [5, 6, 7, 8, 1, 2, 12, 14, 17, 18, 19, 20, 21, 22, 23, 24]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 5, 6, 7, 8, 12, 14, 17, 18, 19, 20, 21, 22, 23, 24])

        unsorted_array = [5, 6, 7, 8, 1, 2]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 5, 6, 7, 8])

        unsorted_array = [5, 6, 7, 8, 1, 2, 12, 14, 17, 18, 19, 20, 21, 22, 23, 24, 4]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 4, 5, 6, 7, 8, 12, 14, 17, 18, 19, 20, 21, 22, 23, 24])