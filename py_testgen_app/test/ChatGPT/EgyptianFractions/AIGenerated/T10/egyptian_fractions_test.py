from py_testgen_app.src.ChatGPT.EgyptianFractions.AIGenerated.T10.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian_fractions = EgyptianFractions()

    def test_case_1(self):
        numerator = 5
        denominator = 7
        expected_result = [2, 5, 35]
        result = self.egyptian_fractions.build(numerator, denominator)
        self.assertEqual(result, expected_result)

    def test_case_2(self):
        numerator = 3
        denominator = 4
        expected_result = [2, 4]
        result = self.egyptian_fractions.build(numerator, denominator)
        self.assertEqual(result, expected_result)

    def test_case_3(self):
        numerator = 8
        denominator = 11
        expected_result = [2, 4, 44]
        result = self.egyptian_fractions.build(numerator, denominator)
        self.assertEqual(result, expected_result)

