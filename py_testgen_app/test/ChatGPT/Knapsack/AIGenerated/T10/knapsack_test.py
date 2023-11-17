from py_testgen_app.src.ChatGPT.Knapsack.AIGenerated.T10.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        # Define common input data for test cases
        self.knapsack = Knapsack()
        self.capacity = 10
        self.weights = [2, 3, 4, 5]
        self.values = [3, 4, 5, 6]

    def test_case_1(self):
        # Test case with a small knapsack capacity
        result = self.knapsack.bottom_up(self.capacity, self.weights, self.values)
        self.assertEqual(result, 7)  # Expected maximum value: 7

    def test_case_2(self):
        # Test case with a larger knapsack capacity
        capacity = 7
        result = self.knapsack.bottom_up(capacity, self.weights, self.values)
        self.assertEqual(result, 8)  # Expected maximum value: 8

    def test_case_3(self):
        # Test case with different items and capacity
        capacity = 6
        weights = [1, 2, 3]
        values = [6, 10, 12]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 22)  # Expected maximum value: 22
