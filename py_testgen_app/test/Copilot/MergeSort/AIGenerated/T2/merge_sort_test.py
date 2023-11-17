from py_testgen_app.src.Copilot.MergeSort.AIGenerated.T2.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort_1(self):
        merge_sort = MergeSort()
        input_list = [1, 3, 2, 4, 5]
        expected_output = [1, 2, 3, 4, 5]
        self.assertEqual(merge_sort.merge_sort(input_list), expected_output)

    def test_merge_sort_2(self):
        merge_sort = MergeSort()
        input_list = [1, 2, 3, 4, 5]
        expected_output = [1, 2, 3, 4, 5]
        self.assertEqual(merge_sort.merge_sort(input_list), expected_output)

    def test_merge_sort_3(self):
        merge_sort = MergeSort()
        input_list = [5, 4, 3, 2, 1]
        expected_output = [1, 2, 3, 4, 5]
        self.assertEqual(merge_sort.merge_sort(input_list), expected_output)
