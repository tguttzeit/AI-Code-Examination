from py_testgen_app.src.Copilot.BinarySearch.PromptOnly.T4.binary_search import BinarySearch

import unittest


class BinarySearchTest(unittest.TestCase):

    # Implement a test method called test_case_1, which tests the following scenario:
    # The parameter x is 0 and the parameter lst is [0].
    # The expected return value is True.
    def test_case_1(self):
        x = 0
        lst = [0]
        expected = True
        actual = BinarySearch().binary_search(x, lst)
        self.assertEqual(expected, actual)

    # Implement a test method called test_case_2, which tests the following scenario:
    # The parameter x is 0 and the parameter lst is [1].
    # The expected return value is False.
    def test_case_2(self):
        x = 0
        lst = [1]
        expected = False
        actual = BinarySearch().binary_search(x, lst)
        self.assertEqual(expected, actual)

    # Implement a test method called test_case_3, which tests the following scenario:
    # The parameter x is 0 and the parameter lst is [0, 1].
    # The expected return value is True.
    def test_case_3(self):
        x = 0
        lst = [0, 1]
        expected = True
        actual = BinarySearch().binary_search(x, lst)
        self.assertEqual(expected, actual)

    # Implement a test method called test_case_4, which tests the following scenario:
    # The parameter x is 0 and the parameter lst is [1, 2].
    # The expected return value is False.
    def test_case_4(self):
        x = 0
        lst = [1, 2]
        expected = False
        actual = BinarySearch().binary_search(x, lst)
        self.assertEqual(expected, actual)

    # Implement a test method called test_case_5, which tests the following scenario:
    # The parameter x is 0 and the parameter lst is [0, 1, 2].
    # The expected return value is True.
    def test_case_5(self):
        x = 0
        lst = [0, 1, 2]
        expected = True
        actual = BinarySearch().binary_search(x, lst)
        self.assertEqual(expected, actual)

    # Implement a test method called test_case_6, which tests the following scenario:
    # The parameter x is 0 and the parameter lst is [1, 2, 3].
    # The expected
