from py_testgen_app.src.ChatGPT.BinarySearch.AIGenerated.T3.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):
    def setUp(self):
        self.binary_search = BinarySearch()

    def test_element_found(self):
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        target = 5
        self.assertTrue(self.binary_search.binary_search(target, arr))

    def test_element_not_found(self):
        arr = [1, 2, 3, 4, 6, 7, 8, 9, 10]
        target = 5
        self.assertFalse(self.binary_search.binary_search(target, arr))

    def test_empty_array(self):
        arr = []
        target = 42
        self.assertFalse(self.binary_search.binary_search(target, arr))

