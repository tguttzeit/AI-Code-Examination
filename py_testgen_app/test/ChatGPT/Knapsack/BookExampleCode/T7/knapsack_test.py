from py_testgen_app.src.ChatGPT.Knapsack.BookExampleCode.T7.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):

    def setUp(self):
        # Initialize the Knapsack instance
        self.knapsack = Knapsack()

    def test_case_1(self):
        # Test case 1
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 10)

    def test_case_2(self):
        # Test case 2
        capacity = 7
        weights = [1, 3, 4, 5]
        values = [1, 4, 5, 7]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 9)

    def test_case_3(self):
        # Test case 3
        capacity = 6
        weights = [2, 2, 2, 2]
        values = [1, 2, 3, 4]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 8)
