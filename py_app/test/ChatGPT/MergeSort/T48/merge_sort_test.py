from py_app.src.ChatGPT.MergeSort.T48.merge_sort import MergeSort

import unittest


class MergeSortTest(unittest.TestCase):

    def setUp(self):
        self.sut = MergeSort()

    def test_should_sort_array(self):
        input_array = [5, 3, 1, 2, 4]
        expected_array = [1, 2, 3, 4, 5]
        sorted_array = self.sut.merge_sort(input_array)
        self.assertEqual(expected_array, sorted_array)


if __name__ == '__main__':
    unittest.main()
