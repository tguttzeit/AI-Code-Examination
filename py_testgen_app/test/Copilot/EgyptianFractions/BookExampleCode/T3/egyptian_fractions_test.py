from py_testgen_app.src.Copilot.EgyptianFractions.BookExampleCode.T3.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):

    def test_egyptian_fractions(self):
        egyptian_fractions = EgyptianFractions()

        self.assertEqual(egyptian_fractions.build(2, 3), [2.0, 6.0])
        self.assertEqual(egyptian_fractions.build(6, 14), [3.0, 11.0, 231.0])
        self.assertEqual(egyptian_fractions.build(12, 13), [2.0, 3.0, 12.0, 156.0])
