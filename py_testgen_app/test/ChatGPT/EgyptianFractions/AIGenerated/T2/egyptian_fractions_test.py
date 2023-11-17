from py_testgen_app.src.ChatGPT.EgyptianFractions.AIGenerated.T2.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian = EgyptianFractions()

    def test_case1(self):
        result = self.egyptian.build(6, 8)
        self.assertEqual(result, [2, 4, 8])

    def test_case2(self):
        result = self.egyptian.build(3, 7)
        self.assertEqual(result, [3, 11, 231])

    def test_case3(self):
        result = self.egyptian.build(5, 6)
        self.assertEqual(result, [2, 3, 6])

