from py_testgen_app.src.ChatGPT.BinarySearch.AIGenerated.T5.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):
    def setUp(self):
        self.binary_search = BinarySearch()

    def test_element_found(self):
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        target = 5
        result = self.binary_search.binary_search(target, arr)
        self.assertTrue(result)

    def test_element_not_found(self):
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        target = 10
        result = self.binary_search.binary_search(target, arr)
        self.assertFalse(result)

    def test_empty_array(self):
        arr = []
        target = 5
        result = self.binary_search.binary_search(target, arr)
        self.assertFalse(result)

    def test_single_element_found(self):
        arr = [5]
        target = 5
        result = self.binary_search.binary_search(target, arr)
        self.assertTrue(result)

    def test_single_element_not_found(self):
        arr = [4]
        target = 5
        result = self.binary_search.binary_search(target, arr)
        self.assertFalse(result)

