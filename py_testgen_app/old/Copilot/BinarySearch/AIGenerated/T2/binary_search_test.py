from py_testgen_app.src.Copilot.BinarySearch.AIGenerated.T2.binary_search import BinarySearch

import unittest
class BinarySearchTest(unittest.TestCase):
    def test_binary_search(self):
        self.assertEqual(BinarySearch().binary_search(1, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)
        self.assertEqual(BinarySearch().binary_search(2, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)
        self.assertEqual(BinarySearch().binary_search(3, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)
        self.assertEqual(BinarySearch().binary_search(4, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)
        self.assertEqual(BinarySearch().binary_search(5, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)
        self.assertEqual(BinarySearch().binary_search(6, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)
        self.assertEqual(BinarySearch().binary_search(7, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)
        self.assertEqual(BinarySearch().binary_search(8, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)
        self.assertEqual(BinarySearch().binary_search(9, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)
        self.assertEqual(BinarySearch().binary_search(10, [1, 2, 3, 4, 5, 6, 7, 8, 9]), False)
        self.assertEqual(BinarySearch().binary_search(11, [1, 2, 3, 4, 5, 6, 7, 8, 9]), False)
        self.assertEqual(BinarySearch().binary_search(12, [1, 2, 3, 4, 5, 6, 7, 8, 9]), False)
        self.assertEqual(BinarySearch().binary_search(13, [
