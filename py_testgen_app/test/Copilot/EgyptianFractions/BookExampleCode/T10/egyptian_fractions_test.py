from py_testgen_app.src.Copilot.EgyptianFractions.BookExampleCode.T10.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_egyptian_fractions_1(self):
        egyptian_fractions = EgyptianFractions()

        self.assertEqual(egyptian_fractions.build(6, 14), [1/3, 1/11, 1/231])

    def test_egyptian_fractions_2(self):
        egyptian_fractions = EgyptianFractions()

        self.assertEqual(egyptian_fractions.build(3, 7), [1/3, 1/11, 1/231])

    def test_egyptian_fractions_3(self):
        egyptian_fractions = EgyptianFractions()

        self.assertEqual(egyptian_fractions.build(12, 13), [1/2, 1/3, 1/12, 1/156])