from py_testgen_app.src.ChatGPT.EgyptianFractions.AIGenerated.T5.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian = EgyptianFractions()

    def test_case1(self):
        numerator = 5
        denominator = 7
        expected_result = [2, 10, 70]
        result = self.egyptian.build(numerator, denominator)
        self.assertEqual(result, expected_result)

    def test_case2(self):
        numerator = 3
        denominator = 4
        expected_result = [2, 4]
        result = self.egyptian.build(numerator, denominator)
        self.assertEqual(result, expected_result)

    def test_case3(self):
        numerator = 8
        denominator = 11
        expected_result = [2, 5, 22, 154]
        result = self.egyptian.build(numerator, denominator)
        self.assertEqual(result, expected_result)

