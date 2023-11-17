from py_testgen_app.src.Copilot.QuickSort.PromptOnly.T10.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_1(self):
        self.assertEqual(QuickSort([1, 2, 3]).sort(5), [1, 2, 3])

    def test_2(self):
        self.assertEqual(QuickSort([1, 3, 2]).sort(5), [1, 2, 3])

    def test_3(self):
        self.assertEqual(QuickSort([3, 2, 1]).sort(5), [1, 2, 3])

    def test_4(self):
        self.assertEqual(QuickSort([1, 2, 3, 4, 5, 6, 7, 8, 9]).sort(5), [1, 2, 3, 4, 5, 6, 7, 8, 9])

    def test_5(self):
        self.assertEqual(QuickSort([9, 8, 7, 6, 5, 4, 3, 2, 1]).sort(5), [1, 2, 3, 4, 5, 6, 7, 8, 9])

    def test_6(self):
        self.assertEqual(QuickSort([1, 9, 2, 8, 3, 7, 4, 6, 5]).sort(5), [1, 2, 3, 4, 5, 6, 7, 8, 9])

    def test_7(self):
        self.assertEqual(QuickSort([5, 6, 7, 8, 9, 1, 2, 3, 4]).sort(5), [1, 2, 3, 4, 5, 6, 7, 8, 9])

    def test_8(self):
        self.assertEqual(QuickSort([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]).sort(5), [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])

    def test_9(self):
        self.assertEqual(QuickSort([10, 9, 8, 7, 6, 5, 4, 3, 2, 1]).sort(5), [1])