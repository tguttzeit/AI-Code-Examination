from py_testgen_app.src.ChatGPT.EgyptianFractions.PromptOnly.T2.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_build_1(self):
        fractions = EgyptianFractions.build(5, 7)
        expected_result = [2, 3, 30]
        self.assertEqual(fractions, expected_result)

    def test_build_2(self):
        fractions = EgyptianFractions.build(3, 11)
        expected_result = [4, 14, 154]
        self.assertEqual(fractions, expected_result)

    def test_build_3(self):
        fractions = EgyptianFractions.build(8, 15)
        expected_result = [2, 3, 40]
        self.assertEqual(fractions, expected_result)
