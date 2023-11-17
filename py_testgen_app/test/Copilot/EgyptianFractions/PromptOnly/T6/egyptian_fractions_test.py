from py_testgen_app.src.Copilot.EgyptianFractions.PromptOnly.T6.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_build(self):
        self.assertEqual(EgyptianFractions().build(0, 2), [])
        self.assertEqual(EgyptianFractions().build(3, 4), [2, 4])
        self.assertEqual(EgyptianFractions().build(6, 14), [3, 11, 231])
        self.assertEqual(EgyptianFractions().build(12, 13), [2, 3, 12, 156])