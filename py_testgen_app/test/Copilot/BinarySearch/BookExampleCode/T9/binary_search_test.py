from py_testgen_app.src.Copilot.BinarySearch.BookExampleCode.T9.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.Testcase):

    def test_binary_search(self):
        binary_search = BinarySearch()
        self.assertTrue(binary_search.binary_search(2, [1, 2, 3]))
        self.assertTrue(binary_search.binary_search(3, [1, 2, 3, 4]))
        self.assertTrue(binary_search.binary_search(4, [1, 2, 3, 4, 5]))
        self.assertTrue(binary_search.binary_search(5, [1, 2, 3, 4, 5, 6]))
        self.assertTrue(binary_search.binary_search(6, [1, 2, 3, 4, 5, 6, 7]))
        self.assertTrue(binary_search.binary_search(7, [1, 2, 3, 4, 5, 6, 7, 8]))
        self.assertTrue(binary_search.binary_search(8, [1, 2, 3, 4, 5, 6, 7, 8, 9]))
        self.assertTrue(binary_search.binary_search(9, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
        self.assertFalse(binary_search.binary_search(10, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
        self.assertFalse(binary_search.binary_search(11, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
        self.assertFalse(binary_search.binary_search(12, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
        self.assertFalse(binary_search.binary_search(13, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
        self.assertFalse(binary_search.binary_search(14, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
        self.assertFalse(binary_search.binary_search(15, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
