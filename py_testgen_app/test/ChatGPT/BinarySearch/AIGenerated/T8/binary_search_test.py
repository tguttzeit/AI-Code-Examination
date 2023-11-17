from py_testgen_app.src.ChatGPT.BinarySearch.AIGenerated.T8.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):
    def setUp(self):
        self.binary_search = BinarySearch()

    def test_element_found(self):
        # Test when the element is found in the middle of the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        target = 5
        self.assertTrue(self.binary_search.binary_search(target, arr))

    def test_element_not_found(self):
        # Test when the element is not in the array
        arr = [10, 20, 30, 40, 50]
        target = 25
        self.assertFalse(self.binary_search.binary_search(target, arr))

    def test_empty_array(self):
        # Test when the array is empty
        arr = []
        target = 42
        self.assertFalse(self.binary_search.binary_search(target, arr))

