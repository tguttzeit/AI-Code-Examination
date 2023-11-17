from py_testgen_app.src.ChatGPT.EgyptianFractions.PromptOnly.T8.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    # Test case 1: Test if build() returns the correct result for 2/5
    def test_egyptian_fractions_2_5(self):
        ef = EgyptianFractions()
        result = ef.build(2, 5)
        self.assertEqual(result, [3, 10])

    # Test case 2: Test if build() returns the correct result for 5/7
    def test_egyptian_fractions_5_7(self):
        ef = EgyptianFractions()
        result = ef.build(5, 7)
        self.assertEqual(result, [1, 2, 3, 42])

    # Test case 3: Test if build() returns the correct result for 3/4
    def test_egyptian_fractions_3_4(self):
        ef = EgyptianFractions()
        result = ef.build(3, 4)
        self.assertEqual(result, [1, 2, 4])
