from py_testgen_app.src.Copilot.MergeSort.AIGenerated.T10.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def setUp(self):
        self.merge_sort = MergeSort()

    def test_merge_sort(self):
        test_list = [5, 3, 2, 1, 4]
        self.assertEqual(self.merge_sort.merge_sort(test_list), [1, 2, 3, 4, 5])

    def test_merge_sort_2(self):
        test_list = [5, 3, 2, 1, 4, 6]
        self.assertEqual(self.merge_sort.merge_sort(test_list), [1, 2, 3, 4, 5, 6])

    def test_merge_sort_3(self):
        test_list = [5, 3, 2, 1, 4, 6, 7]
        self.assertEqual(self.merge_sort.merge_sort(test_list), [1, 2, 3, 4, 5, 6, 7])
