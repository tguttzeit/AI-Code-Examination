from py_testgen_app.src.Copilot.QuickSort.PromptOnly.T3.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort(self):
        test_list = [5, 3, 1, 2, 4]
        QuickSort().sort(test_list)
        self.assertEqual(test_list, [1, 2, 3, 4, 5])

    def test_sort2(self):
        test_list = [5, 3, 1, 2, 4]
        QuickSort().sort(test_list)
        self.assertNotEqual(test_list, [5, 3, 1, 2, 4])

    def test_sort3(self):
        test_list = [5, 3, 1, 2, 4]
        QuickSort().sort(test_list)
        self.assertEqual(test_list, [1, 2, 3, 4, 5])