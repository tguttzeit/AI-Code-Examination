from py_testgen_app.src.Copilot.Knapsack.PromptOnly.T6.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):

    def test_bottom_up_1(self):
        self.assertEqual(Knapsack().bottom_up(5, [1, 2, 3], [6, 10, 12]), 22)

    def test_bottom_up_2(self):
        self.assertEqual(Knapsack().bottom_up(4, [1, 2, 3], [6, 10, 12]), 18)

    def test_bottom_up_3(self):
        self.assertEqual(Knapsack().bottom_up(3, [1, 2, 3], [6, 10, 12]), 16)