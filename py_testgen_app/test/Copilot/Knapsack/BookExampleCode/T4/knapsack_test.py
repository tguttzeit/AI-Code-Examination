from py_testgen_app.src.Copilot.Knapsack.BookExampleCode.T4.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_knapsack(self):
        # Test case 1
        weights = [1, 2, 3]
        values = [6, 10, 12]
        capacity = 5
        result = Knapsack().bottom_up(capacity, weights, values)
        self.assertEqual(result, 22)

        # Test case 2
        weights = [1, 2, 3, 8, 7, 4]
        values = [20, 5, 10, 40, 15, 25]
        capacity = 10
        result = Knapsack().bottom_up(capacity, weights, values)
        self.assertEqual(result, 60)

        # Test case 3
        weights = [1, 2, 3, 8, 7, 4]
        values = [20, 5, 10, 40, 15, 25]
        capacity = 50
        result = Knapsack().bottom_up(capacity, weights, values)
        self.assertEqual(result, 115)