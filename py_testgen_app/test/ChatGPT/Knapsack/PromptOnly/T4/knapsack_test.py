from py_testgen_app.src.ChatGPT.Knapsack.PromptOnly.T4.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    
    def test_bottom_up_with_empty_lists(self):
        # Test case with empty lists
        capacity = 10
        weights = []
        values = []
        knapsack = Knapsack()
        max_value = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(max_value, 0)

    def test_bottom_up_with_valid_input(self):
        # Test case with valid input data
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        knapsack = Knapsack()
        max_value = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(max_value, 10)

    def test_bottom_up_with_large_capacity(self):
        # Test case with a large capacity that cannot be filled completely
        capacity = 20
        weights = [5, 7, 8, 10]
        values = [10, 13, 15, 20]
        knapsack = Knapsack()
        max_value = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(max_value, 33)
