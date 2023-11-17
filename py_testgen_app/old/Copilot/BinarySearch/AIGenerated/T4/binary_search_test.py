from py_testgen_app.src.Copilot.BinarySearch.AIGenerated.T4.binary_search import BinarySearch

import unittest
class BinarySearchTest(unittest.TestCase):
    def test_case_1(self):
        self.assertTrue(BinarySearch.binary_search(5, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))

    def test_case_2(self):
        self.assertTrue(BinarySearch.binary_search(1, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))

    def test_case_3(self):
        self.assertTrue(BinarySearch.binary_search(10, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
