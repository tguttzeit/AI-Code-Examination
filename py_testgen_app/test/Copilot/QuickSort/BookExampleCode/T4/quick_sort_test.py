from py_testgen_app.src.Copilot.QuickSort.BookExampleCode.T4.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_quick_sort(self):
        unsorted_array = [10, 1, 3, 5, 8, 7, 9, 6, 4, 2]
        quick_sort = QuickSort()
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
