from py_testgen_app.src.Copilot.EgyptianFractions.AIGenerated.T2.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_egyptian_fractions(self):
        ef = EgyptianFractions()
        self.assertEqual(ef.build(2, 3), [2, 6])
        self.assertEqual(ef.build(6, 14), [3, 11, 231])
        self.assertEqual(ef.build(12, 13), [2, 3, 12, 156])
        self.assertEqual(ef.build(4, 13), [4, 13])
