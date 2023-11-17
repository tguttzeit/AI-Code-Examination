from py_testgen_app.src.ChatGPT.Knapsack.PromptOnly.T5.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_case_1(self):
        weights = [1, 2, 3]
        values = [6, 10, 12]
        capacity = 5
        self.assertEqual(Knapsack.bottom_up(capacity, weights, values), 22)

    def test_case_2(self):
        weights = [2, 2, 3]
        values = [3, 4, 6]
        capacity = 5
        self.assertEqual(Knapsack.bottom_up(capacity, weights, values), 7)

    def test_case_3(self):
        weights = [1, 2, 3, 4, 5]
        values = [10, 20, 30, 40, 50]
        capacity = 8
        self.assertEqual(Knapsack.bottom_up(capacity, weights, values), 90)
