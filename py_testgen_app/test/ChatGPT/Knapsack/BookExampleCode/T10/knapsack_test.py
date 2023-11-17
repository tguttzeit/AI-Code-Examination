from py_testgen_app.src.ChatGPT.Knapsack.BookExampleCode.T10.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):

    def setUp(self):
        self.knapsack = Knapsack()

    def test_knapsack_case1(self):
        # Test case with small inputs
        capacity = 5
        weights = [2, 1, 3]
        values = [10, 6, 12]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 22)

    def test_knapsack_case2(self):
        # Test case with larger capacity
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 7 + 6 + 5)  # Optimal solution: Take all items

    def test_knapsack_case3(self):
        # Test case with no items
        capacity = 7
        weights = []
        values = []
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 0)  # No items to select, so the result should be 0
