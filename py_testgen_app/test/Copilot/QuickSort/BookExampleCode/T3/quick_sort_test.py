from py_testgen_app.src.Copilot.QuickSort.BookExampleCode.T3.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_quick_sort(self):
        quick_sort = QuickSort()
        unsorted_array = [5, 1, 8, 2, 6, 3, 9, 4, 0, 7]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])