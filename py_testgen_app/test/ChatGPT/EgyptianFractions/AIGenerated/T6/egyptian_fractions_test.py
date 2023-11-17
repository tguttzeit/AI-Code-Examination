from py_testgen_app.src.ChatGPT.EgyptianFractions.AIGenerated.T6.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian = EgyptianFractions()

    def test_egyptian_fraction_1(self):
        result = self.egyptian.build(2, 3)
        self.assertEqual(result, [2, 3])

    def test_egyptian_fraction_2(self):
        result = self.egyptian.build(5, 7)
        self.assertEqual(result, [2, 5, 70])

    def test_egyptian_fraction_3(self):
        result = self.egyptian.build(8, 11)
        self.assertEqual(result, [2, 4, 44])

