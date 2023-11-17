from py_testgen_app.src.Copilot.BinarySearch.BookExampleCode.T8.binary_search import BinarySearch

import unittest
class BinarySearchTest(unittest.Testcase):
    def test_binary_search_1(self):
        binary_search = BinarySearch()
        self.assertTrue(binary_search.binary_search(1, [1,2,3,4,5,6,7,8,9,10]))

    def test_binary_search_2(self):
        binary_search = BinarySearch()
        self.assertTrue(binary_search.binary_search(2, [1,2,3,4,5,6,7,8,9,10]))

    def test_binary_search_3(self):
        binary_search = BinarySearch()
        self.assertTrue(binary_search.binary_search(3, [1,2,3,4,5,6,7,8,9,10]))

    def test_binary_search_4(self):
        binary_search = BinarySearch()
        self.assertTrue(binary_search.binary_search(4, [1,2,3,4,5,6,7,8,9,10]))

    def test_binary_search_5(self):
        binary_search = BinarySearch()
        self.assertTrue(binary_search.binary_search(5, [1,2,3,4,5,6,7,8,9,10]))

    def test_binary_search_6(self):
        binary_search = BinarySearch()
        self.assertTrue(binary_search.binary_search(6, [1,2,3,4,5,6,7,8,9,10]))

    def test_binary_search_7(self):
        binary_search = BinarySearch()
        self.assertTrue(binary_search.binary_search(7, [1,2,3,4,5,6,7,8,9,10]))

    def test_binary_search_8(self):
        binary_search = BinarySearch()
        self.assertTrue(binary_search.binary_search(8, [1,2,3,4,5,6,7,8,9,10]))

    def test_binary_search_9(self):
        binary_search = BinarySearch()
        self.assertTrue(binary_search.binary_search(9, [1,2,3,4,5,6,7,8,9,10]))

    def test_binary_search_10(self):
        binary_search = BinarySearch()
        self.assertTrue(binary_search.binary_search(10, [1,2,3,4,5,6,7,8,9,10]))

    def test_binary_search_11(self):
        binary_search = BinarySearch()
        self.assertFalse(binary_search.binary_search(11, [1,
