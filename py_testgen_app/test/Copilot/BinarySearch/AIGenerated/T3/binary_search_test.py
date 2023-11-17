from py_testgen_app.src.Copilot.BinarySearch.AIGenerated.T3.binary_search import BinarySearch

import unittest
class BinarySearchTest(unittest.TestCase):
    def test_binary_search_1(self):
        bs = BinarySearch()
        self.assertEqual(bs.binary_search(1, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)

    def test_binary_search_2(self):
        bs = BinarySearch()
        self.assertEqual(bs.binary_search(10, [1, 2, 3, 4, 5, 6, 7, 8, 9]), False)

    def test_binary_search_3(self):
        bs = BinarySearch()
        self.assertEqual(bs.binary_search(5, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)

    def test_binary_search_4(self):
        bs = BinarySearch()
        self.assertEqual(bs.binary_search(0, [1, 2, 3, 4, 5, 6, 7, 8, 9]), False)

    def test_binary_search_5(self):
        bs = BinarySearch()
        self.assertEqual(bs.binary_search(9, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)

    def test_binary_search_6(self):
        bs = BinarySearch()
        self.assertEqual(bs.binary_search(8, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)

    def test_binary_search_7(self):
        bs = BinarySearch()
        self.assertEqual(bs.binary_search(7, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)

    def test_binary_search_8(self):
        bs = BinarySearch()
        self.assertEqual(bs.binary_search(6, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)

    def test_binary_search_9(self):
        bs = BinarySearch()
        self.assertEqual(bs.binary_search(4, [1, 2, 3, 4, 5, 6, 7, 8, 9]), True)

    def test_binary_search_10(self):
        bs = BinarySearch()
