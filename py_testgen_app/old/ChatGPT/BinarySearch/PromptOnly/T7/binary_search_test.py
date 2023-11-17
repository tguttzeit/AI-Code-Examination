from py_testgen_app.src.ChatGPT.BinarySearch.PromptOnly.T7.binary_search import BinarySearch

import unittest


class BinarySearchTest(unittest.TestCase):
    def test_binary_search_element_found(self):
        arr = [1, 2, 3, 4, 5, 6, 7]
        self.assertTrue(BinarySearch.binary_search(4, arr))

    def test_binary_search_element_not_found(self):
        arr = [1, 2, 3, 5, 6, 7]
        self.assertFalse(BinarySearch.binary_search(4, arr))

    def test_binary_search_empty_list(self):
        arr = []
        self.assertFalse(BinarySearch.binary_search(4, arr))


