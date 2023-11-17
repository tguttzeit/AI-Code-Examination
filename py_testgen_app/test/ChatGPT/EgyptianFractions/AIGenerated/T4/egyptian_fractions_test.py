from py_testgen_app.src.ChatGPT.EgyptianFractions.AIGenerated.T4.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian = EgyptianFractions()

    def test_case1(self):
        result = self.egyptian.build(2, 5)
        self.assertEqual(result, [3, 10])

    def test_case2(self):
        result = self.egyptian.build(5, 8)
        self.assertEqual(result, [2, 5, 40])

    def test_case3(self):
        result = self.egyptian.build(4, 9)
        self.assertEqual(result, [3, 6, 18])

