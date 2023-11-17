from py_testgen_app.src.Copilot.BinarySearch.BookExampleCode.T1.binary_search import BinarySearch

import unittest
class BinarySearchTest(unittest.Testcase):

    def test_binary_search_1(self):
        self.assertEqual(BinarySearch().binary_search(1, [1, 2, 3]), True)

    def test_binary_search_2(self):
        self.assertEqual(BinarySearch().binary_search(2, [1, 2, 3]), True)

    def test_binary_search_3(self):
        self.assertEqual(BinarySearch().binary_search(3, [1, 2, 3]), True)
