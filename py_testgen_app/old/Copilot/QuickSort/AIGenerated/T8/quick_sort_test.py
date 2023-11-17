from py_testgen_app.src.Copilot.QuickSort.AIGenerated.T8.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort_empty_array(self):
        quick_sort = QuickSort()
        empty_array = []
        quick_sort.sort(empty_array)
        self.assertEqual(empty_array, [])

    def test_sort_array_with_one_element(self):
        quick_sort = QuickSort()
        array_with_one_element = [1]
        quick_sort.sort(array_with_one_element)
        self.assertEqual(array_with_one_element, [1])

    def test_sort_array_with_two_elements(self):
        quick_sort = QuickSort()
        array_with_two_elements = [2, 1]
        quick_sort.sort(array_with_two_elements)
        self.assertEqual(array_with_two_elements, [1, 2])

    def test_sort_array_with_three_elements(self):
        quick_sort = QuickSort()
        array_with_three_elements = [3, 2, 1]
        quick_sort.sort(array_with_three_elements)
        self.assertEqual(array_with_three_elements, [1, 2, 3])

    def test_sort_array_with_four_elements(self):
        quick_sort = QuickSort()
        array_with_four_elements = [4, 3, 2, 1]
        quick_sort.sort(array_with_four_elements)
        self.assertEqual(array_with_four_elements, [1, 2, 3, 4])

    def test_sort_array_with_five_elements(self):
        quick_sort = QuickSort()
        array_with_five_elements = [5, 4, 3, 2, 1]
        quick_sort.sort(array_with_five_elements)
        self.assertEqual(array_with_five_elements, [1, 2, 3, 4, 5])

    def test_sort_array_with_six_elements(self):
        quick_sort = QuickSort()
        array_with_six_elements = [6, 5, 4, 3, 2, 1]
        quick_sort.sort(array_with_six_elements)
        self.assertEqual(array_with_six_elements, [1, 2, 3, 4, 5, 6])

    def test_sort_array_with_seven_elements(self):
        quick_sort = QuickSort()
        array_with_seven_elements = [7, 6, 5, 4, 3, 2, 1]
        quick_sort.sort(array_with_seven_elements)
        self.assertEqual(array_with_seven_elements, [1, 2, 3, 4, 5, 6, 7])

    def test_sort_array_with_eight_elements