from py_testgen_app.src.Copilot.Knapsack.BookExampleCode.T1.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_knapsack_1(self):
        knapsack = Knapsack()
        self.assertEqual(knapsack.bottom_up(50, [10, 20, 30], [60, 100, 120]), 220)
    
    def test_knapsack_2(self):
        knapsack = Knapsack()
        self.assertEqual(knapsack.bottom_up(10, [1, 2, 3], [10, 15, 40]), 55)
    
    def test_knapsack_3(self):
        knapsack = Knapsack()
        self.assertEqual(knapsack.bottom_up(10, [1, 2, 3], [10, 15, 40]), 55)