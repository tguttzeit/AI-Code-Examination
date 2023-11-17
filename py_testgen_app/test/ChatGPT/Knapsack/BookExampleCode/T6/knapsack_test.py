from py_testgen_app.src.ChatGPT.Knapsack.BookExampleCode.T6.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):

    def setUp(self):
        self.knapsack = Knapsack()

    def test_case1(self):
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 7)

    def test_case2(self):
        capacity = 5
        weights = [1, 2, 3, 4, 5]
        values = [5, 4, 3, 2, 1]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 5)

    def test_case3(self):
        capacity = 7
        weights = [3, 4, 2, 1]
        values = [4, 5, 3, 1]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 7)
