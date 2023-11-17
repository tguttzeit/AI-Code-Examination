from py_testgen_app.src.Copilot.BinarySearch.BookExampleCode.T5.binary_search import BinarySearch

import unittest
class BinarySearchTest(unittest.Testcase):

    def test_binary_search(self):
        binary_search = BinarySearch()
        key = 3
        arr = [1, 2, 3, 4, 5]
        self.assertTrue(binary_search.binary_search(key, arr))

        key = 6
        arr = [1, 2, 3, 4, 5]
        self.assertFalse(binary_search.binary_search(key, arr))

        key = 1
        arr = [1, 2, 3, 4, 5]
        self.assertTrue(binary_search.binary_search(key, arr))
