from py_testgen_app.src.Copilot.BinarySearch.BookExampleCode.T7.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.Testcase):
    def setUp(self):
        self.binary_search = BinarySearch()

    def tearDown(self):
        pass

    def test_binary_search(self):
        self.assertTrue(self.binary_search.binary_search(2, [1, 2, 3, 4, 5]))
        self.assertFalse(self.binary_search.binary_search(0, [1, 2, 3, 4, 5]))
        self.assertTrue(self.binary_search.binary_search(5, [1, 2, 3, 4, 5]))
        self.assertFalse(self.binary_search.binary_search(6, [1, 2, 3, 4, 5]))

    