from py_app.src.Copilot.QuickSort.T6.quick_sort import QuickSort

import unittest


class QuickSortTest(unittest.TestCase):

    def setUp(self):
        self.sut = QuickSort()

    def test_should_sort_array(self):
        input_array = [5, 3, 1, 2, 4]
        expected_array = [1, 2, 3, 4, 5]
        self.sut.sort(input_array)
        self.assertEqual(expected_array, input_array)


if __name__ == '__main__':
    unittest.main()
