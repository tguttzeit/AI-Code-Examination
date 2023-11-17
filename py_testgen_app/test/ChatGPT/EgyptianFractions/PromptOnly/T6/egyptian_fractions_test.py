from py_testgen_app.src.ChatGPT.EgyptianFractions.PromptOnly.T6.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):

    def test_build_with_valid_fraction(self):
        # Test case for a valid fraction (e.g., 3/7)
        numerator = 3
        denominator = 7
        result = EgyptianFractions().build(numerator, denominator)
        expected = [2, 7, 21]  # Expected result for 3/7 as an Egyptian fraction
        self.assertEqual(result, expected)

    def test_build_with_unit_fraction(self):
        # Test case for a unit fraction (e.g., 1/4)
        numerator = 1
        denominator = 4
        result = EgyptianFractions().build(numerator, denominator)
        expected = [4]  # Expected result for 1/4 as an Egyptian fraction
        self.assertEqual(result, expected)

    def test_build_with_improper_fraction(self):
        # Test case for an improper fraction (e.g., 5/3)
        numerator = 5
        denominator = 3
        result = EgyptianFractions().build(numerator, denominator)
        expected = [2, 3]  # Expected result for 5/3 as an Egyptian fraction
        self.assertEqual(result, expected)

