from py_testgen_app.src.Copilot.QuickSort.AIGenerated.T6.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort(self):
        quick_sort = QuickSort()
        test_array = [4, 7, 1, 9, 3, 2, 0, 5, 6, 8]
        quick_sort.sort(test_array)
        self.assertEqual(test_array, [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])

        test_array = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
        quick_sort.sort(test_array)
        self.assertEqual(test_array, [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])

        test_array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
        quick_sort.sort(test_array)
        self.assertEqual(test_array, [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])