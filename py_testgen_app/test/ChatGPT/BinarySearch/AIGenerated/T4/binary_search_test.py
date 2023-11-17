from py_testgen_app.src.ChatGPT.BinarySearch.AIGenerated.T4.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):
    def setUp(self):
        self.binary_search = BinarySearch()

    def test_element_found(self):
        arr = [1, 3, 5, 7, 9, 11, 13]
        target = 7
        self.assertTrue(self.binary_search.binary_search(target, arr))

    def test_element_not_found(self):
        arr = [2, 4, 6, 8, 10]
        target = 7
        self.assertFalse(self.binary_search.binary_search(target, arr))

    def test_empty_list(self):
        arr = []
        target = 42
        self.assertFalse(self.binary_search.binary_search(target, arr))

