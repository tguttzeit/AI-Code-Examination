from py_testgen_app.src.ChatGPT.Knapsack.AIGenerated.T9.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()

    def test_case1(self):
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 7)  # Expected maximum value

    def test_case2(self):
        capacity = 5
        weights = [2, 1, 3]
        values = [4, 2, 3]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 7)  # Expected maximum value

    def test_case3(self):
        capacity = 8
        weights = [1, 3, 4, 5]
        values = [2, 4, 5, 7]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 9)  # Expected maximum value
