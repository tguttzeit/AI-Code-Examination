from py_testgen_app.src.ChatGPT.Knapsack.BookExampleCode.T3.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        # Initialize common variables for all test cases
        self.knapsack = Knapsack()
    
    def test_empty_knapsack(self):
        # Test when the knapsack has no items (empty).
        capacity = 10
        weights = []
        values = []
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 0)

    def test_basic_knapsack(self):
        # Test a basic scenario with a small knapsack.
        capacity = 5
        weights = [2, 3, 4]
        values = [3, 4, 5]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 7)

    def test_large_knapsack(self):
        # Test a larger knapsack with more items.
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 12)
