from py_testgen_app.src.Copilot.QuickSort.AIGenerated.T4.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort(self):
        # test 1
        unsorted_array = [5, 3, 1, 2, 4]
        expected = [1, 2, 3, 4, 5]
        QuickSort().sort(unsorted_array)
        self.assertEqual(unsorted_array, expected)

        # test 2
        unsorted_array = [1, 3, 5, 4, 2]
        expected = [1, 2, 3, 4, 5]
        QuickSort().sort(unsorted_array)
        self.assertEqual(unsorted_array, expected)

        # test 3
        unsorted_array = [5, 4, 3, 2, 1]
        expected = [1, 2, 3, 4, 5]
        QuickSort().sort(unsorted_array)
        self.assertEqual(unsorted_array, expected)