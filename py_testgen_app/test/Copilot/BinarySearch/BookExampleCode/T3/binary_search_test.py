from py_testgen_app.src.Copilot.BinarySearch.BookExampleCode.T3.binary_search import BinarySearch

import unittest
class BinarySearchTest(unittest.Testcase):

    def setUp(self):
        self.binary_search = BinarySearch()

    def test_binary_search_case1(self):
        key = 1
        arr = [1, 2, 3, 4, 5]
        self.assertTrue(self.binary_search.binary_search(key, arr))

    def test_binary_search_case2(self):
        key = 6
        arr = [1, 2, 3, 4, 5]
        self.assertFalse(self.binary_search.binary_search(key, arr))

    def test_binary_search_case3(self):
        key = 3
        arr = [1, 2, 3, 4, 5]
        self.assertTrue(self.binary_search.binary_search(key, arr))
