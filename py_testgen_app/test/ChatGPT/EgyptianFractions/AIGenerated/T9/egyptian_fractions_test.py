from py_testgen_app.src.ChatGPT.EgyptianFractions.AIGenerated.T9.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian = EgyptianFractions()

    def test_case_1(self):
        result = self.egyptian.build(2, 3)
        self.assertEqual(result, [2, 7])

    def test_case_2(self):
        result = self.egyptian.build(5, 8)
        self.assertEqual(result, [2, 4, 8])

    def test_case_3(self):
        result = self.egyptian.build(3, 4)
        self.assertEqual(result, [2, 4])

