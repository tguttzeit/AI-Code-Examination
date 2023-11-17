from py_testgen_app.src.ChatGPT.EgyptianFractions.AIGenerated.T8.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian_fractions = EgyptianFractions()

    def test_case1(self):
        numerator = 5
        denominator = 7
        expected_result = [2, 4, 28]
        result = self.egyptian_fractions.build(numerator, denominator)
        self.assertEqual(result, expected_result)

    def test_case2(self):
        numerator = 4
        denominator = 13
        expected_result = [4, 18, 468]
        result = self.egyptian_fractions.build(numerator, denominator)
        self.assertEqual(result, expected_result)

    def test_case3(self):
        numerator = 3
        denominator = 11
        expected_result = [4, 14, 154]
        result = self.egyptian_fractions.build(numerator, denominator)
        self.assertEqual(result, expected_result)

