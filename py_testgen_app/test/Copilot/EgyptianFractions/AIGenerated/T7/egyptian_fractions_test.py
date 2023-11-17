from py_testgen_app.src.Copilot.EgyptianFractions.AIGenerated.T7.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_build_1(self):
        fractions = EgyptianFractions()
        self.assertEqual(fractions.build(2, 3), [2, 3, 6])

    def test_build_2(self):
        fractions = EgyptianFractions()
        self.assertEqual(fractions.build(6, 14), [3, 6, 7, 42])

    def test_build_3(self):
        fractions = EgyptianFractions()
        self.assertEqual(fractions.build(12, 13), [2, 3, 12, 156])
