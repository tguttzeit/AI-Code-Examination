from py_testgen_app.src.Copilot.EgyptianFractions.PromptOnly.T5.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionTest(unittest.TestCase):
    def setUp(self):
        self.egyptian_fraction = EgyptianFractions()

    def test_build(self):
        self.assertEqual(self.egyptian_fraction.build(2, 3), [2, 6])
        self.assertEqual(self.egyptian_fraction.build(6, 14), [1, 3, 11, 231])
        self.assertEqual(self.egyptian_fraction.build(12, 13), [1, 2, 3, 12, 156])
