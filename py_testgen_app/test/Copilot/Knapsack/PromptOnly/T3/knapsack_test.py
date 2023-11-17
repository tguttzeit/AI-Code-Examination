from py_testgen_app.src.Copilot.Knapsack.PromptOnly.T3.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test1(self):
        self.assertEqual(Knapsack().bottom_up(10, [1, 2, 3], [1, 2, 3]), 10)

    def test2(self):
        self.assertEqual(Knapsack().bottom_up(10, [1, 2, 3], [1, 1, 1]), 3)

    def test3(self):
        self.assertEqual(Knapsack().bottom_up(10, [1, 2, 3], [1, 3, 1]), 4)