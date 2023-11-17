from py_testgen_app.src.ChatGPT.BinarySearch.PromptOnly.T5.binary_search import BinarySearch

import unittest


# Create the BinarySearchTest class
class BinarySearchTest(unittest.TestCase):
    def test_binary_search_existing_element(self):
        # Test when the target element is in the list
        arr = [1, 2, 3, 4, 5]
        target = 3
        self.assertTrue(BinarySearch().binary_search(target, arr))

    def test_binary_search_non_existing_element(self):
        # Test when the target element is not in the list
        arr = [1, 2, 3, 4, 5]
        target = 6
        self.assertFalse(BinarySearch().binary_search(target, arr))

    def test_binary_search_empty_list(self):
        # Test when the list is empty
        arr = []
        target = 42
        self.assertFalse(BinarySearch().binary_search(target, arr))

