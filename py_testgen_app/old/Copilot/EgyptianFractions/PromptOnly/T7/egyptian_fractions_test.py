from py_testgen_app.src.Copilot.EgyptianFractions.PromptOnly.T7.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionTest(unittest.TestCase):
    def test_build(self):
        self.assertEqual(EgyptianFractions.build(2, 3), [2, 3, 6])
        self.assertEqual(EgyptianFractions.build(6, 14), [3, 7, 98])
        self.assertEqual(EgyptianFractions.build(12, 13), [2, 4, 52, 676])
        self.assertEqual(EgyptianFractions.build(50, 4187), [84, 4187])
