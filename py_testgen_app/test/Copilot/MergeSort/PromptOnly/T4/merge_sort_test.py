from py_testgen_app.src.Copilot.MergeSort.PromptOnly.T4.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    # Implement a test method called test_merge_sort_1() to test the method merge_sort().
    # The test case must be able to test the following scenario:
    # The input list is empty.
    # The expected output list is empty.
    def test_merge_sort_1(self):
        merge_sort = MergeSort()
        input_list = []
        expected_output_list = []
        actual_output_list = merge_sort.merge_sort(input_list)
        self.assertEqual(expected_output_list, actual_output_list)

    # Implement a test method called test_merge_sort_2() to test the method merge_sort().
    # The test case must be able to test the following scenario:
    # The input list contains only one element.
    # The expected output list is the same as the input list.
    def test_merge_sort_2(self):
        merge_sort = MergeSort()
        input_list = [1]
        expected_output_list = [1]
        actual_output_list = merge_sort.merge_sort(input_list)
        self.assertEqual(expected_output_list, actual_output_list)

    # Implement a test method called test_merge_sort_3() to test the method merge_sort().
    # The test case must be able to test the following scenario:
    # The input list contains more than one element.
    # The expected output list is a sorted version of the input list.
    def test_merge_sort_3(self):
        merge_sort = MergeSort()
        input_list = [1, 5, 2, 4, 3]
        expected_output_list = [1, 2, 3, 4, 5]
        actual_output_list = merge_sort.merge_sort(input_list)
        self.assertEqual(expected_output_list, actual_output_list)
