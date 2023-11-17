from py_testgen_app.src.ChatGPT.BinarySearch.PromptOnly.T4.binary_search import BinarySearch

import unittest
class BinarySearchTest(unittest.TestCase):

    def test_element_in_list(self):
        # Test when the element is present in the list
        data = [1, 2, 3, 4, 5]
        element = 3
        result = BinarySearch().binary_search(element, data)
        self.assertTrue(result)

    def test_element_not_in_list(self):
        # Test when the element is not present in the list
        data = [1, 2, 3, 4, 5]
        element = 6
        result = BinarySearch().binary_search(element, data)
        self.assertFalse(result)

    def test_empty_list(self):
        # Test when the list is empty
        data = []
        element = 42
        result = BinarySearch().binary_search(element, data)
        self.assertFalse(result)


