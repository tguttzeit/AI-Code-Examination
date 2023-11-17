from py_testgen_app.src.Copilot.QuickSort.PromptOnly.T8.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_QuickSort(self):
        qs = QuickSort()
        self.assertEqual(qs.sort([1, 2, 3, 4, 5, 6, 7, 8, 9]), [1, 2, 3, 4, 5, 6, 7, 8, 9])
        self.assertEqual(qs.sort([9, 8, 7, 6, 5, 4, 3, 2, 1]), [1, 2, 3, 4, 5, 6, 7, 8, 9])
        self.assertEqual(qs.sort([9, 8, 7, 6, 5, 4, 3, 2, 1, 0]), [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])