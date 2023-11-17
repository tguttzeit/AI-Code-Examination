from py_testgen_app.src.Copilot.QuickSort.AIGenerated.T2.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def setUp(self):
        self.quick_sort = QuickSort()

    def test_empty_array(self):
        unsorted_array = []
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [])

    def test_one_element_array(self):
        unsorted_array = [1]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1])

    def test_two_element_array(self):
        unsorted_array = [2, 1]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2])

    def test_three_element_array(self):
        unsorted_array = [3, 2, 1]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3])

    def test_four_element_array(self):
        unsorted_array = [3, 2, 1, 4]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4])

    def test_five_element_array(self):
        unsorted_array = [3, 2, 1, 5, 4]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])

    def test_six_element_array(self):
        unsorted_array = [3, 2, 1, 6, 5, 4]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6])

    def test_seven_element_array(self):
        unsorted_array = [3, 2, 1, 7, 6, 5, 4]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7])

    def test_eight_element_array(self):
        unsorted_array = [3, 2, 1, 8, 7, 6, 5, 4]
        self.quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7, 8])

    def test_nine