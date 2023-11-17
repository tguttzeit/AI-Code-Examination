from py_testgen_app.src.Copilot.EgyptianFractions.AIGenerated.T1.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.ef = EgyptianFractions()

    def test_ef(self):
        self.assertEqual(self.ef.build(2, 3), [2, 6])
        self.assertEqual(self.ef.build(6, 14), [3, 11, 231])
        self.assertEqual(self.ef.build(12, 13), [2, 3, 12, 156])
