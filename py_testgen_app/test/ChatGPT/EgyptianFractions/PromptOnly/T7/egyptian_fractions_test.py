from py_testgen_app.src.ChatGPT.EgyptianFractions.PromptOnly.T7.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_build_case1(self):
        # Test when numerator is smaller than denominator
        numerator = 3
        denominator = 7
        expected_result = [1, 2, 7]
        fractions = EgyptianFractions()
        result = fractions.build(numerator, denominator)
        self.assertEqual(result, expected_result)

    def test_build_case2(self):
        # Test when numerator is equal to denominator
        numerator = 5
        denominator = 5
        expected_result = [1]
        fractions = EgyptianFractions()
        result = fractions.build(numerator, denominator)
        self.assertEqual(result, expected_result)

    def test_build_case3(self):
        # Test when numerator is larger than denominator
        numerator = 8
        denominator = 3
        expected_result = [3, 3, 3]
        fractions = EgyptianFractions()
        result = fractions.build(numerator, denominator)
        self.assertEqual(result, expected_result)
