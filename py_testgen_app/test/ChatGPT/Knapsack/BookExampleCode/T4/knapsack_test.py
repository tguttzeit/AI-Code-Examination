from py_testgen_app.src.ChatGPT.Knapsack.BookExampleCode.T4.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        # Initialize a Knapsack instance for testing
        self.knapsack = Knapsack()

    def test_empty_knapsack(self):
        capacity = 0
        weights = []
        values = []
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 0, "Empty knapsack should yield 0 value")

    def test_basic_knapsack(self):
        capacity = 7
        weights = [3, 4, 2, 1]
        values = [4, 5, 3, 2]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 9, "Basic knapsack test failed")

    def test_large_capacity(self):
        capacity = 100
        weights = [10, 20, 30]
        values = [60, 100, 120]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 220, "Large capacity test failed")

