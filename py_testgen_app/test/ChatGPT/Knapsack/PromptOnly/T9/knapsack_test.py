from py_testgen_app.src.ChatGPT.Knapsack.PromptOnly.T9.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    
    def test_empty_knapsack(self):
        # Test with an empty knapsack
        knapsack = Knapsack()
        capacity = 10
        weights = []
        values = []
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 0)

    def test_basic_knapsack(self):
        # Test with a basic knapsack problem
        knapsack = Knapsack()
        capacity = 5
        weights = [2, 3, 4]
        values = [3, 4, 5]
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 7)

    def test_large_capacity(self):
        # Test with a large capacity
        knapsack = Knapsack()
        capacity = 100
        weights = [10, 20, 30]
        values = [60, 100, 120]
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 220)
