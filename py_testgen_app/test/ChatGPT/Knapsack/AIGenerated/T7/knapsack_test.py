from py_testgen_app.src.ChatGPT.Knapsack.AIGenerated.T7.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()

    def test_knapsack_case1(self):
        capacity = 5
        weights = [2, 3, 1]
        values = [4, 5, 3]
        expected_result = 7
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, expected_result)

    def test_knapsack_case2(self):
        capacity = 10
        weights = [5, 4, 6, 3]
        values = [10, 40, 30, 50]
        expected_result = 90
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, expected_result)

    def test_knapsack_case3(self):
        capacity = 8
        weights = [1, 3, 4, 5]
        values = [2, 5, 7, 10]
        expected_result = 13
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, expected_result)
