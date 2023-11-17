from py_testgen_app.src.ChatGPT.Knapsack.AIGenerated.T4.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def test_case1(self):
        knapsack = Knapsack()
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        expected_result = 10  # Expected maximum value
        self.assertEqual(knapsack.bottom_up(capacity, weights, values), expected_result)

    def test_case2(self):
        knapsack = Knapsack()
        capacity = 8
        weights = [3, 2, 4, 1]
        values = [5, 3, 5, 2]
        expected_result = 10  # Expected maximum value
        self.assertEqual(knapsack.bottom_up(capacity, weights, values), expected_result)

    def test_case3(self):
        knapsack = Knapsack()
        capacity = 6
        weights = [1, 2, 3]
        values = [3, 4, 5]
        expected_result = 7  # Expected maximum value
        self.assertEqual(knapsack.bottom_up(capacity, weights, values), expected_result)
