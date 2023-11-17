from py_testgen_app.src.Copilot.Knapsack.BookExampleCode.T8.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    
    def setUp(self):
        self.knapsack = Knapsack()
        self.capacity = 50
        self.weights = [10, 20, 30]
        self.values = [60, 100, 120]
        self.result = 220
        
    def test_bottom_up(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, self.values), self.result)

    def test_bottom_up2(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, self.values), self.result)

    def test_bottom_up3(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, self.values), self.result)