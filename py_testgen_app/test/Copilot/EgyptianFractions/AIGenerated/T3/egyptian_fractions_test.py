from py_testgen_app.src.Copilot.EgyptianFractions.AIGenerated.T3.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian_fractions = EgyptianFractions()

    def test_egyptian_fractions(self):
        self.assertEqual(self.egyptian_fractions.build(6, 14), [3, 11, 231])
        self.assertEqual(self.egyptian_fractions.build(2, 3), [2, 6])
        self.assertEqual(self.egyptian_fractions.build(12, 13), [2, 3, 12, 156])
        self.assertEqual(self.egyptian_fractions.build(1, 3), [3])

    def tearDown(self):
        self.egyptian_fractions = None
