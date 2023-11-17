from py_testgen_app.src.ChatGPT.Knapsack.BookExampleCode.T9.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        # Create an instance of the Knapsack class for testing
        self.knapsack = Knapsack()

    def test_case_1(self):
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 10, "Test case 1 failed")

    def test_case_2(self):
        capacity = 5
        weights = [1, 2, 3]
        values = [6, 10, 12]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 22, "Test case 2 failed")

    def test_case_3(self):
        capacity = 8
        weights = [2, 2, 4, 5]
        values = [3, 5, 7, 9]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 12, "Test case 3 failed")
