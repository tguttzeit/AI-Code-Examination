from py_testgen_app.src.ChatGPT.Knapsack.BookExampleCode.T8.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):

    def setUp(self):
        self.knapsack = Knapsack()

    def test_empty_knapsack(self):
        # Test when the knapsack has zero capacity.
        capacity = 0
        weights = []
        values = []
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 0)

    def test_basic_knapsack(self):
        # Test a basic scenario with small inputs.
        capacity = 5
        weights = [2, 3, 1]
        values = [10, 20, 15]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 25)

    def test_large_knapsack(self):
        # Test a scenario with a large knapsack capacity.
        capacity = 100
        weights = [30, 20, 10, 5]
        values = [120, 100, 60, 40]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 220)
