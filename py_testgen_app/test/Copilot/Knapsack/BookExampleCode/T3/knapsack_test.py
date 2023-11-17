from py_testgen_app.src.Copilot.Knapsack.BookExampleCode.T3.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()
        self.capacity = 50
        self.weights = [10, 20, 30]
        self.values = [60, 100, 120]

    def test_bottom_up(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, self.values), 220)

    def test_bottom_up_with_zero_capacity(self):
        self.assertEqual(self.knapsack.bottom_up(0, self.weights, self.values), 0)

    def test_bottom_up_with_empty_weights(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, [], self.values), 0)

    def test_bottom_up_with_empty_values(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, []), 0)

    def test_bottom_up_with_weights_and_values_of_different_lengths(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, [10, 20], [60, 100, 120]), 160)

    def test_bottom_up_with_negative_capacity(self):
        self.assertEqual(self.knapsack.bottom_up(-1, self.weights, self.values), 0)

    def test_bottom_up_with_negative_weights(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, [-10, -20, -30], self.values), 0)

    def test_bottom_up_with_negative_values(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, [-60, -100, -120]), 0)

    def test_bottom_up_with_negative_capacity_and_weights(self):
        self.assertEqual(self.knapsack.bottom_up(-1, [-10, -20, -30], self.values), 0)

    def test_bottom_up_with_negative_capacity_and_values(self):
        self.assertEqual(self.knapsack.bottom_up(-1, self.weights, [-60, -100, -120]), 0)

    def test_bottom_up_with_negative_weights_and_values(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, [-10, -20, -30], [-60, -100, -120]), 0)

    def test_bottom_up_with_negative_capacity_and_weights_and_values(self):
        self.assertEqual(self.knapsack.bottom_up(-1, [-10, -20, -30], [-60, -100, -120]), 0)