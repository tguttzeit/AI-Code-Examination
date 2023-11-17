from py_testgen_app.src.ChatGPT.BinarySearch.PromptOnly.T6.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.TestCase):
    def test_binary_search_found(self):
        arr = [1, 2, 3, 4, 5, 6]
        self.assertTrue(BinarySearch.binary_search(3, arr))

    def test_binary_search_not_found(self):
        arr = [1, 2, 3, 4, 5, 6]
        self.assertFalse(BinarySearch.binary_search(7, arr))

    def test_binary_search_empty_list(self):
        arr = []
        self.assertFalse(BinarySearch.binary_search(42, arr))

