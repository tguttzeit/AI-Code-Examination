from py_testgen_app.src.Copilot.Knapsack.PromptOnly.T7.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_bottom_up_1(self):
        # arrange
        capacity = 5
        weights = [1, 2, 3]
        values = [6, 10, 12]
        expected = 22

        # act
        actual = Knapsack().bottom_up(capacity, weights, values)

        # assert
        self.assertEqual(expected, actual)

    def test_bottom_up_2(self):
        # arrange
        capacity = 5
        weights = [1, 2, 3]
        values = [6, 10, 12]
        expected = 22

        # act
        actual = Knapsack().bottom_up(capacity, weights, values)

        # assert
        self.assertEqual(expected, actual)

    def test_bottom_up_3(self):
        # arrange
        capacity = 5
        weights = [1, 2, 3]
        values = [6, 10, 12]
        expected = 22

        # act
        actual = Knapsack().bottom_up(capacity, weights, values)

        # assert
        self.assertEqual(expected, actual)