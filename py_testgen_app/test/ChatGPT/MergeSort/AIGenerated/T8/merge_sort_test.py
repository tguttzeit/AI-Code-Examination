from py_testgen_app.src.ChatGPT.MergeSort.AIGenerated.T8.merge_sort import MergeSort

import unittest

class TestMergeSort(unittest.TestCase):
    def setUp(self):
        self.mergesort = MergeSort()

    def test_empty_list(self):
        arr = []
        result = self.mergesort.merge_sort(arr)
        self.assertEqual(result, [])

    def test_sorted_list(self):
        arr = [1, 2, 3, 4, 5]
        result = self.mergesort.merge_sort(arr)
        self.assertEqual(result, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        arr = [5, 4, 3, 2, 1]
        result = self.mergesort.merge_sort(arr)
        self.assertEqual(result, [1, 2, 3, 4, 5])

    def test_random_order_list(self):
        arr = [3, 1, 4, 2, 5]
        result = self.mergesort.merge_sort(arr)
        self.assertEqual(result, [1, 2, 3, 4, 5])
