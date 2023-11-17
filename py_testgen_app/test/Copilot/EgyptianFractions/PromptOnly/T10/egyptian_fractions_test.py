from py_testgen_app.src.Copilot.EgyptianFractions.PromptOnly.T10.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionTest(unittest.TestCase):

    def test_build(self):
        egyptian_fraction = EgyptianFractions()
        self.assertEqual(egyptian_fraction.build(5, 121), [25, 757, 763309, 873960180913, 1527612795642093418846225])

    def test_build2(self):
        egyptian_fraction = EgyptianFractions()
        self.assertEqual(egyptian_fraction.build(6, 14), [3, 11, 231])

    def test_build3(self):
        egyptian_fraction = EgyptianFractions()
        self.assertEqual(egyptian_fraction.build(12, 13), [2, 3, 12, 156])
