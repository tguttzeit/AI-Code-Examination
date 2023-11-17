from py_testgen_app.src.Copilot.BinarySearch.AIGenerated.T6.binary_search import BinarySearch

import unittest
class BinarySearchTest(unittest.TestCase):
    def test_binary_search(self):
        binary_search = BinarySearch()
        self.assertEqual(binary_search.binary_search(1, [1, 2, 3, 4, 5]), True)
        self.assertEqual(binary_search.binary_search(2, [1, 2, 3, 4, 5]), True)
        self.assertEqual(binary_search.binary_search(3, [1, 2, 3, 4, 5]), True)
        self.assertEqual(binary_search.binary_search(4, [1, 2, 3, 4, 5]), True)
        self.assertEqual(binary_search.binary_search(5, [1, 2, 3, 4, 5]), True)
        self.assertEqual(binary_search.binary_search(6, [1, 2, 3, 4, 5]), False)
        self.assertEqual(binary_search.binary_search(7, [1, 2, 3, 4, 5]), False)
        self.assertEqual(binary_search.binary_search(8, [1, 2, 3, 4, 5]), False)
        self.assertEqual(binary_search.binary_search(9, [1, 2, 3, 4, 5]), False)
        self.assertEqual(binary_search.binary_search(10, [1, 2, 3, 4, 5]), False)
        self.assertEqual(binary_search.binary_search(11, [1, 2, 3, 4, 5]), False)
