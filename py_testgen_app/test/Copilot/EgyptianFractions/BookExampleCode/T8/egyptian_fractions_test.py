from py_testgen_app.src.Copilot.EgyptianFractions.BookExampleCode.T8.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_egyptian_fractions(self):
        egyptian_fractions = EgyptianFractions()

        expected = [1 / 2, 1 / 6]
        self.assertEqual(expected, egyptian_fractions.build(2, 3))

        expected = [1 / 3, 1 / 11, 1 / 231]
        self.assertEqual(expected, egyptian_fractions.build(6, 7))

        expected = [1 / 4, 1 / 5, 1 / 20]
        self.assertEqual(expected, egyptian_fractions.build(3, 4))

        expected = [1 / 2, 1 / 3, 1 / 13, 1 / 237]
        self.assertEqual(expected, egyptian_fractions.build(7, 8))

        expected = [1 / 2, 1 / 3, 1 / 13, 1 / 2366, 1 / 138180]
        self.assertEqual(expected, egyptian_fractions.build(15, 16))

        expected = [1 / 2, 1 / 3, 1 / 13, 1 / 2366, 1 / 138180, 1 / 21879117]
        self.assertEqual(expected, egyptian_fractions.build(31, 32))

        expected = [1 / 2, 1 / 3, 1 / 13, 1 / 2366, 1 / 138180, 1 / 21879117, 1 / 4989198160]
        self.assertEqual(expected, egyptian_fractions.build(63, 64))

        expected = [1 / 2, 1 / 3, 1 / 13, 1 / 2366, 1 / 138180, 1 / 21879117, 1 / 4989198160, 1 / 1576307839993]
        self.assertEqual(expected, egyptian_fractions.build(127, 128))

        expected = [1 / 2, 1 / 3, 1 / 13, 1 / 2366, 1 / 138180, 1 / 21879117, 1 / 4989198160, 1 ]
