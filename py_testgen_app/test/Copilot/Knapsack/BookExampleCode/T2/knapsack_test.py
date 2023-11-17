from py_testgen_app.src.Copilot.Knapsack.BookExampleCode.T2.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()
        self.values = [60, 100, 120]
        self.weights = [10, 20, 30]
        self.capacity = 50

    def test_bottom_up(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, self.values), 220)

    def test_bottom_up2(self):
        self.values = [1, 2, 3]
        self.weights = [4, 5, 6]
        self.capacity = 7
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, self.values), 3)

    def test_bottom_up3(self):
        self.values = [1, 2, 3]
        self.weights = [4, 5, 6]
        self.capacity = 1
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, self.values), 0)

    def test_bottom_up4(self):
        self.values = [1, 2, 3]
        self.weights = [4, 5, 6]
        self.capacity = 0
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, self.values), 0)

    def test_bottom_up5(self):
        self.values = [1, 2, 3]
        self.weights = [4, 5, 6]
        self.capacity = -1
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, self.values), 0)

    def test_bottom_up6(self):
        self.values = [1, 2, 3]
        self.weights = [4, 5, 6]
        self.capacity = 100
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, self.values), 3)