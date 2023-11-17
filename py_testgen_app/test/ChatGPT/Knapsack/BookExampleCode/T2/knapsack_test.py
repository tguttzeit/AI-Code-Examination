from py_testgen_app.src.ChatGPT.Knapsack.BookExampleCode.T2.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):

    def setUp(self):
        # Create an instance of the Knapsack class
        self.knapsack = Knapsack()

    def test_knapsack_case1(self):
        # Test with small values, weights, and capacity
        capacity = 5
        weights = [2, 1, 3]
        values = [10, 4, 7]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 11)

    def test_knapsack_case2(self):
        # Test with larger values and weights
        capacity = 10
        weights = [5, 4, 6, 3]
        values = [10, 40, 30, 50]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 90)

    def test_knapsack_case3(self):
        # Test with an empty knapsack (capacity is 0)
        capacity = 0
        weights = [2, 1, 3]
        values = [10, 4, 7]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 0)
