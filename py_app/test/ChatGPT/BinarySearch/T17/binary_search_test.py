from py_app.src.ChatGPT.BinarySearch.T17.binary_search import BinarySearch

import unittest


class BinarySearchTest(unittest.TestCase):
    def setUp(self):
        self.sut = BinarySearch()

    def test_should_return_true_for_input_number_found(self):
        input_number = 1
        input_array = [1, 2, 3, 4, 5]

        expected = True
        actual = self.sut.binary_search(input_number, input_array)

        self.assertEqual(expected, actual)

    def test_should_return_false_for_input_number_not_found(self):
        input_number = 0
        input_array = [1, 2, 3, 4, 5]

        expected = False
        actual = self.sut.binary_search(input_number, input_array)

        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
