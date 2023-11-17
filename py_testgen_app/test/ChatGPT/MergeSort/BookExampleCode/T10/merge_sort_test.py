from py_testgen_app.src.ChatGPT.MergeSort.BookExampleCode.T10.merge_sort import MergeSort

import unittest

class TestMergeSort(unittest.TestCase):
    def setUp(self):
        self.merge_sorter = MergeSort()

    def test_empty_list(self):
        input_list = []
        expected_output = []
        self.assertEqual(self.merge_sorter.merge_sort(input_list), expected_output)

    def test_sorted_list(self):
        input_list = [1, 2, 3, 4, 5]
        expected_output = [1, 2, 3, 4, 5]
        self.assertEqual(self.merge_sorter.merge_sort(input_list), expected_output)

    def test_reverse_sorted_list(self):
        input_list = [5, 4, 3, 2, 1]
        expected_output = [1, 2, 3, 4, 5]
        self.assertEqual(self.merge_sorter.merge_sort(input_list), expected_output)

    def test_random_list(self):
        input_list = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        expected_output = [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9]
        self.assertEqual(self.merge_sorter.merge_sort(input_list), expected_output)

