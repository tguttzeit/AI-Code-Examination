from py_testgen_app.src.Copilot.EgyptianFractions.AIGenerated.T5.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_1(self):
        ef = EgyptianFractions()
        self.assertEqual(ef.build(6,14), [3, 11, 231])
    def test_2(self):
        ef = EgyptianFractions()
        self.assertEqual(ef.build(2,5), [3, 7, 70])
    def test_3(self):
        ef = EgyptianFractions()
        self.assertEqual(ef.build(3,7), [3, 11, 231])
