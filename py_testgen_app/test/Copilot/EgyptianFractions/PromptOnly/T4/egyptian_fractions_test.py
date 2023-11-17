from py_testgen_app.src.Copilot.EgyptianFractions.PromptOnly.T4.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionTest(unittest.TestCase):
    def test_build(self):
        self.assertEqual(EgyptianFractions().build(5, 121), [25, 757, 763309])
        self.assertEqual(EgyptianFractions().build(7, 103), [15, 16, 648, 97392])
        self.assertEqual(EgyptianFractions().build(8, 101), [13, 104, 3120])
        self.assertEqual(EgyptianFractions().build(11, 121), [11, 121])
        self.assertEqual(EgyptianFractions().build(13, 121), [10, 11, 121])
