from py_testgen_app.src.Copilot.Knapsack.PromptOnly.T5.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):

    # Test 1: weights = [1, 2, 3, 4, 5], values = [1, 2, 3, 4, 5], capacity = 5
    def test_bottom_up_1(self):
        self.assertEqual(Knapsack().bottom_up(5, [1, 2, 3, 4, 5], [1, 2, 3, 4, 5]), 5)

    # Test 2: weights = [1, 2, 3, 4, 5], values = [1, 2, 3, 4, 5], capacity = 6
    def test_bottom_up_2(self):
        self.assertEqual(Knapsack().bottom_up(6, [1, 2, 3, 4, 5], [1, 2, 3, 4, 5]), 6)

    # Test 3: weights = [1, 2, 3, 4, 5], values = [1, 2, 3, 4, 5], capacity = 7
    def test_bottom_up_3(self):
        self.assertEqual(Knapsack().bottom_up(7, [1, 2, 3, 4, 5], [1, 2, 3, 4, 5]), 7)