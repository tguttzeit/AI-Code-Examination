from py_testgen_app.src.Copilot.EgyptianFractions.AIGenerated.T6.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_build(self):
        ef = EgyptianFractions()
        self.assertEqual([2, 3, 13, 28], ef.build(2, 15))
        self.assertEqual([1, 2, 3, 6], ef.build(6, 7))
        self.assertEqual([1, 2, 3, 7, 42], ef.build(7, 8))
