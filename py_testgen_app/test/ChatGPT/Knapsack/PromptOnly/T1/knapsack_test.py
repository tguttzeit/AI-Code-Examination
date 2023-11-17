from py_testgen_app.src.ChatGPT.Knapsack.PromptOnly.T1.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):

    def test_bottom_up_case1(self):
        knapsack = Knapsack()
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        max_value = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(max_value, 7)  # Expected maximum value is 7

    def test_bottom_up_case2(self):
        knapsack = Knapsack()
        capacity = 6
        weights = [1, 2, 3]
        values = [10, 15, 40]
        max_value = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(max_value, 65)  # Expected maximum value is 65

    def test_bottom_up_case3(self):
        knapsack = Knapsack()
        capacity = 7
        weights = [3, 4, 5]
        values = [30, 50, 60]
        max_value = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(max_value, 90)  # Expected maximum value is 90
