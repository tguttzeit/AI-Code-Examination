from py_testgen_app.src.ChatGPT.Knapsack.AIGenerated.T6.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        # Initialize the Knapsack instance with sample data for testing
        self.knapsack = Knapsack()
        self.capacity = 10
        self.weights = [2, 3, 4, 5]
        self.values = [3, 4, 5, 6]

    def test_knapsack_case1(self):
        # Test when capacity is 10, weights are [2, 3, 4, 5], and values are [3, 4, 5, 6]
        # The expected result is 10, which represents the maximum value that can be obtained
        result = self.knapsack.bottom_up(self.capacity, self.weights, self.values)
        self.assertEqual(result, 10)

    def test_knapsack_case2(self):
        # Test with smaller capacity, where items 0 and 1 should be included
        capacity = 5
        # Expected result: 7 (3 + 4)
        result = self.knapsack.bottom_up(capacity, self.weights, self.values)
        self.assertEqual(result, 7)

    def test_knapsack_case3(self):
        # Test with larger capacity, where all items should be included
        capacity = 15
        # Expected result: 18 (3 + 4 + 5 + 6)
        result = self.knapsack.bottom_up(capacity, self.weights, self.values)
        self.assertEqual(result, 18)
