from py_testgen_app.src.Copilot.MergeSort.AIGenerated.T7.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def setUp(self):
        self.merge_sort = MergeSort()

    def test_merge_sort_case_1(self):
        input_list = [1, 5, 6, 2, 4, 3]
        expected_output = [1, 2, 3, 4, 5, 6]
        self.assertEqual(self.merge_sort.merge_sort(input_list), expected_output)

    def test_merge_sort_case_2(self):
        input_list = [1, 2, 3, 4, 5, 6]
        expected_output = [1, 2, 3, 4, 5, 6]
        self.assertEqual(self.merge_sort.merge_sort(input_list), expected_output)

    def test_merge_sort_case_3(self):
        input_list = [6, 5, 4, 3, 2, 1]
        expected_output = [1, 2, 3, 4, 5, 6]
        self.assertEqual(self.merge_sort.merge_sort(input_list), expected_output)
