from py_testgen_app.src.Copilot.QuickSort.AIGenerated.T3.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_empty_array(self):
        empty_array = []
        QuickSort().sort(empty_array)
        self.assertEqual([], empty_array)

    def test_array_with_one_element(self):
        array_with_one_element = [1]
        QuickSort().sort(array_with_one_element)
        self.assertEqual([1], array_with_one_element)

    def test_array_with_two_elements(self):
        array_with_two_elements = [2, 1]
        QuickSort().sort(array_with_two_elements)
        self.assertEqual([1, 2], array_with_two_elements)

    def test_array_with_three_elements(self):
        array_with_three_elements = [3, 2, 1]
        QuickSort().sort(array_with_three_elements)
        self.assertEqual([1, 2, 3], array_with_three_elements)

    def test_array_with_four_elements(self):
        array_with_four_elements = [4, 3, 2, 1]
        QuickSort().sort(array_with_four_elements)
        self.assertEqual([1, 2, 3, 4], array_with_four_elements)

    def test_array_with_five_elements(self):
        array_with_five_elements = [5, 4, 3, 2, 1]
        QuickSort().sort(array_with_five_elements)
        self.assertEqual([1, 2, 3, 4, 5], array_with_five_elements)

    def test_array_with_six_elements(self):
        array_with_six_elements = [6, 5, 4, 3, 2, 1]
        QuickSort().sort(array_with_six_elements)
        self.assertEqual([1, 2, 3, 4, 5, 6], array_with_six_elements)

    def test_array_with_seven_elements(self):
        array_with_seven_elements = [7, 6, 5, 4, 3, 2, 1]
        QuickSort().sort(array_with_seven_elements)
        self.assertEqual([1, 2, 3, 4, 5, 6, 7], array_with_seven_elements)

    def test_array_with_eight_elements(self):
        array_with_eight_elements = [8, 7, 6, 5, 4, 3, 2, 1]
        QuickSort().sort(array_with_eight_elements)
        self.assertEqual([1, 2, 3], 1)