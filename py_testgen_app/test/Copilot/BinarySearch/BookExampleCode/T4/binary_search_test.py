from py_testgen_app.src.Copilot.BinarySearch.BookExampleCode.T4.binary_search import BinarySearch

import unittest
class BinarySearchTest(unittest.Testcase):
    def test_binary_search(self):
        self.assertEqual(BinarySearch().binary_search(3, [1,2,3,4,5]), True)
        self.assertEqual(BinarySearch().binary_search(6, [1,2,3,4,5]), False)
        self.assertEqual(BinarySearch().binary_search(4, [1,2,3,4,5]), True)
        self.assertEqual(BinarySearch().binary_search(0, [1,2,3,4,5]), False)
        self.assertEqual(BinarySearch().binary_search(1, [1,2,3,4,5]), True)
        self.assertEqual(BinarySearch().binary_search(2, [1,2,3,4,5]), True)
        self.assertEqual(BinarySearch().binary_search(5, [1,2,3,4,5]), True)
