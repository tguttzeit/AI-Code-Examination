from py_testgen_app.src.Copilot.BinarySearch.PromptOnly.T1.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.TestCase):
    # Implement a test method called test_binary_search_1().
    def test_binary_search_1(self):
        # Define a variable called search_list and initialize it to [1, 2, 3, 4, 5].
        search_list = [1, 2, 3, 4, 5]
        # Define a variable called search_item and initialize it to 3.
        search_item = 3
        # Define a variable called expected and initialize it to True.
        expected = True
        # Define a variable called actual and initialize it to the result of calling binary_search() with search_item and search_list as parameters.
        actual = binary_search(search_item, search_list)
        # Assert that actual equals expected.
        self.assertEqual(actual, expected)
        # Define a variable called search_item and initialize it to 6.
        search_item = 6
        # Define a variable called expected and initialize it to False.
        expected = False
        # Define a variable called actual and initialize it to the result of calling binary_search() with search_item and search_list as parameters.
        actual = binary_search(search_item, search_list)
        # Assert that actual equals expected.
        self.assertEqual(actual, expected)
        # Define a variable called search_item and initialize it to 0.
        search_item = 0
        # Define a variable called expected and initialize it to False.
        expected = False
        # Define a variable called actual and initialize it to the result of calling binary_search() with search_item and search_list as parameters.
        actual = binary_search(search_item, search_list)
        # Assert that actual equals expected.
        self.assertEqual(actual, expected)
        # Define a variable called search_list and initialize it to [].
        search_list = []
        # Define a variable called search_item and initialize it to 1.
        search_item = 1
        # Define a variable called expected and initialize it to False.
        expected = False
        # Define a variable called actual and initialize it to the result of calling binary_search() with search_item and search_list as parameters.
        actual = binary_search(search_item, search_list)
        # Assert that actual equals expected.
        self.assertEqual(actual, expected)
        # Define a variable called search_list and initialize it to [1].
        search_list = [1]
        # Define a variable called search_item and initialize it to 1.
        search_item