from py_testgen_app.src.Copilot.Knapsack.PromptOnly.T10.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_knapsack_1(self):
        """
        Test case to test the Knapsack problem with a capacity of 10, weights [1, 3, 4, 5] and values [1, 4, 5, 7].
        """
        self.assertEqual(Knapsack.bottom_up(10, [1, 3, 4, 5], [1, 4, 5, 7]), 9)

    def test_knapsack_2(self):
        """
        Test case to test the Knapsack problem with a capacity of 10, weights [1, 3, 4, 5] and values [1, 4, 5, 7].
        """
        self.assertEqual(Knapsack.bottom_up(10, [1, 3, 4, 5], [1, 4, 5, 7]), 9)

    def test_knapsack_3(self):
        """
        Test case to test the Knapsack problem with a capacity of 10, weights [1, 3, 4, 5] and values [1, 4, 5, 7].
        """
        self.assertEqual(Knapsack.bottom_up(10, [1, 3, 4, 5], [1, 4, 5, 7]), 9)