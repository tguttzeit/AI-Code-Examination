from py_testgen_app.src.Copilot.Knapsack.PromptOnly.T2.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_1(self):
        self.assertEqual(Knapsack().bottom_up(10, [5, 4, 6, 3], [10, 40, 30, 50]), 90)

    def test_2(self):
        self.assertEqual(Knapsack().bottom_up(10, [5, 4, 6, 3], [10, 40, 30, 50]), 90)

    def test_3(self):
        self.assertEqual(Knapsack().bottom_up(10, [5, 4, 6, 3], [10, 40, 30, 50]), 90)